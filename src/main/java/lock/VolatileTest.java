package lock;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

public class VolatileTest {
    // 看源码用
    StringBuffer sb = new StringBuffer();
    private static AtomicInteger atomicInteger = new AtomicInteger(0);
    private final static Unsafe U = getUnsafe();
    private static ReentrantLock lock = new ReentrantLock();
    private static ConcurrentHashMap<Integer,Integer> map = new ConcurrentHashMap<>();
    private static HashMap<Integer,Integer> map2 = new HashMap<>();
    private static ThreadLocal<Integer> threadLocal = new ThreadLocal<>();


    // 手撕CAS
    private volatile int value;
    private final static long valueOffset;
    static {
        try {
            valueOffset = U.objectFieldOffset(VolatileTest.class.getDeclaredField("value"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public boolean CompareAndSet(int a) {
        return U.compareAndSwapInt(this, valueOffset, value, a);
    }

    // 手撕AtomicInteger
    public void CasSet(int a) {
        // 加自旋
        int lodValue;
        do {
            lodValue = U.getIntVolatile(this, valueOffset);
        }while (!U.compareAndSwapInt(this, valueOffset, lodValue, a));
    }


    // 反射实例化
    public static Unsafe getUnsafe() {
        try {
            Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
            theUnsafe.setAccessible(true);
            return (Unsafe) theUnsafe.get(null);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }



    // volatile功能展示
    public static volatile int i;
    // 测试检测修改
    private void testI() {
        while (i != 1) {
            System.out.println("支线程未观测到i改变");
            // 通过Unsafe添加屏障，避免jvm编译器优化
            getUnsafe().loadFence();
        }
        System.out.println("退出");
    }

    public static void main(String[] args) {

        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(
                5,
                5,
                1L,
                TimeUnit.MINUTES,
                new ArrayBlockingQueue<Runnable>(10));

        VolatileTest Test = new VolatileTest();
        if (Test.CompareAndSet(10)) {
            System.out.println(Test.value);
        }
        // 创建支线程
        VolatileTest test = new VolatileTest();
        new Thread(() -> {
            test.testI();
        }).start();

        // 主线程睡眠2秒后修改i
        LockSupport.parkNanos(3*1000*1000*1000L);
        VolatileTest.i = 1;
        System.out.println("主线程已改变i");
        int[] a = {1,1,2,3};

    }
}
