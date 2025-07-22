public class AddTwoNumbers {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Double round = 0.0;
        int result, temp1, temp2;
        result = l1.val + l2.val;
        while(l1.next != null && l2.next != null) {
            if (l1.next != null) {
                l1 = l1.next;
                temp1 = l1.val;
            } else temp1 = 0;
            if (l2.next != null) {
                l2 = l2.next;
                temp2 = l2.val;
            } else temp2 = 0;
            result += (temp1 + temp2) * (int)Math.pow(10.0, ++round);
        }
        ListNode res = new ListNode(result % 10);
        result -= res.val;
        int i = 1;
        while (result != 0){
            res.next = new ListNode(result % (int)Math.pow(10.0, ++i));
            result -= res.val;
        }
        return res;
    }


     public static class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {
        String s = "hijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789hijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789hijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789hijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789hijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789hijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        int start = 0;
        int max = 0;
        char[] chars = s.toCharArray();
        if (chars.length == 0) return 0;
        int[] charSpec = new int[128];
        int i = 0;
        for (; i < chars.length; i++) {
            int index = chars[i] - ' ';
            if (charSpec[index] == 0) {
                charSpec[index] = i + 1;
            } else {
                if (charSpec[index] - 1 < start) {
                    charSpec[index] = i + 1;
                    continue;
                }
                max = Math.max(max, i - start);
                start = charSpec[index];
                charSpec[index] = i + 1;
            }
        }
        max = Math.max(max, chars.length - start);
        return max;
    }

}

