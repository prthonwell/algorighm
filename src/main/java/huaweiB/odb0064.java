package huaweiB;

import java.util.*;

public class odb0064 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double distanceA = sc.nextDouble(),
                distanceB = sc.nextDouble(),
                taxiSpeed = sc.nextDouble(),
                waitTime = sc.nextDouble(),
                walkSpeed = sc.nextDouble();
        double cost1 = waitTime + distanceA / taxiSpeed * 1000;
        double cost2 = distanceB / walkSpeed * 1000;
        System.out.println(cost1 > cost2 ? "Walk" : cost1 == cost2 ? "same" : "Taxi");
    }
}
