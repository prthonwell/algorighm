package NEWLeetCode.from1to10;

import ob.ListNode;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        ListNode head=null,tail=null;
//        int carry=0;
//
//        while(l1!=null || l2!=null){
//            int n1=l1!=null?l1.val:0;
//            int n2=l2!=null?l2.val:0;
//            int sum=n1+n2+carry;
//            if(head ==null){
//                head=tail=new ListNode(sum % 10);
//            }else{
//                tail.next=new ListNode(sum % 10);
//                tail=tail.next;
//            }
//            carry=sum/10;
//            if(l1!=null){
//                l1=l1.next;
//            }
//            if(l2 != null){
//                l2=l2.next;
//            }
//        }
//        if(carry !=0){
//            tail.next=new ListNode(carry);
//        }
//        return head;
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else {
            int rest = 0;
            ListNode res = new ListNode(0);
            ListNode pre = res;
            pre.next = l1;
            while (l1 != null || l2 != null) {
                int sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + rest;
                rest = sum / 10;
                pre.next = new ListNode(sum % 10);
                pre = pre.next;
                l1 = l1 == null ? null : l1.next;
                l2 = l2 == null ? null : l2.next;
            }
            if (rest == 0) return res.next;
            else {
                pre.next = new ListNode(1);
                return res.next;
            }
        }
    }
}