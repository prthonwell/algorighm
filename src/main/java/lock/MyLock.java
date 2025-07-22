package lock;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.LockSupport;

public class MyLock {
    private volatile int state;
    private long stateOffset;
    private Unsafe U;
    private volatile Thread thread;
    private volatile List<Thread> threads = new CopyOnWriteArrayList<>();

    {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            U = (Unsafe) field.get(null);
            stateOffset = U.objectFieldOffset(MyLock.class.getDeclaredField("state"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private int getState() {
        return state;
    }

    private boolean setState(int state) {
        return U.compareAndSwapInt(this, stateOffset, 0, state);
    }

    private Thread getThread() {
        return thread;
    }

    private void setThread(Thread thread) {
        this.thread = thread;
    }

    public void lock() {
        Thread CT = Thread.currentThread();
        // 自旋获取锁
        for(;;) {
            if (setState(1)) {
                setThread(CT);
                break;
            } else if (getThread() == CT) {
                state++;
                break;
            } else {
                threads.add(CT);
                LockSupport.park();
            }
        }
    }
    public void unlock() {
        Thread RuningThread = getThread();
        if (RuningThread != Thread.currentThread()) {
            throw new RuntimeException("please do lock first");
        }

        int s = getState();
        s--;
        if (s == 0) {
            setThread(null);
            if (!threads.isEmpty()) {
                Thread luckT = threads.remove(0);
                LockSupport.unpark(luckT);
            }
            state = 0;
        }else {
            state--;
        }

    }
}
