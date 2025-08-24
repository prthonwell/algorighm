package leetCode.from201to300;

import java.util.*;

class MedianFinder {
        PriorityQueue<Integer> greater;
        PriorityQueue<Integer> lower;

        public MedianFinder() {
            greater = new PriorityQueue<>();
            lower = new PriorityQueue<>((a, b) -> b - a);
        }

        public void addNum(int num) {
            if (lower.isEmpty()) {
                lower.add(num);
                return;
            }
            int mid = lower.peek();
            if (num <= mid) {
                lower.add(num);
            } else {
                greater.add(num);
            }
            while (greater.size() > lower.size()) {
                lower.add(greater.poll());
            }
            while (lower.size() > greater.size() + 1) {
                greater.add(lower.poll());
            }
        }

        public double findMedian() {
            if (lower.size() > greater.size()) {
                return lower.peek();
            } else {
                return (greater.peek() + lower.peek()) / 2.0;
            }
        }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */