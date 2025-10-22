import java.util.*;

public class Main {
    public static void main(String[] args) {
        String name = "superadmin.gdsy";
        if (!name.matches("[a-zA-Z0-9_@.-]+")) {
            System.out.println("wrong name");
        } else {
            System.out.println("right name");
        }

    }
}