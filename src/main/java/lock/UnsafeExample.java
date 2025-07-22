package lock;

import sun.misc.Unsafe;
import java.lang.reflect.Field;

public class UnsafeExample {
    private static final Unsafe unsafe;
    private static final long ageOffset;

    static {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            unsafe = (Unsafe) field.get(null);
            ageOffset = unsafe.objectFieldOffset(User.class.getDeclaredField("age"));
        } catch (Exception e) {
            throw new Error(e);
        }
    }

    public static void main(String[] args) {
        User user = new User();
        unsafe.putInt(user, ageOffset, 20);
        System.out.println("Age: " + unsafe.getInt(user, ageOffset));
    }
}

    class User {
        private int age = 10;
    }