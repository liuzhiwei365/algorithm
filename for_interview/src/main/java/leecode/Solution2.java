package leecode;


class Solution2 {

    public static void main(String[] args) {

    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {


        ListNode pre = new ListNode(0);
        ListNode cur = pre;

        int tmp = 0;

        while(l1!=null || l2!=null ){
            int num1= l1==null? 0 : l1.val;
            int num2= l2==null? 0 : l2.val;

            int total = num1+num2 +tmp;

            int val= total % 10;
             tmp = total /10;

            cur.next = new ListNode(val);
            cur = cur.next;

            if(l1!=null) l1=l1.next;
            if(l2!=null) l2=l2.next;
        }


        if(tmp == 1) {
            cur.next = new ListNode(tmp);
        }

        return pre.next;
    }



    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}