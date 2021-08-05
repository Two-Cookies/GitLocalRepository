/**
 * 2. 两数相加：
 *  两个非空的链表，以倒叙的形式存储，并且每个节点只能存储 一位 数字。请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 */

public class LC0002 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode();
        ListNode node = pre;
        int temp = 0;
        while (l1!=null && l2!=null){
            int num = l1.val +l2.val + temp;
            int sum = num%10;
            node.next = new ListNode(sum + temp);
            node = node.next;
            temp = num/10;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1!=null){
            int num = l1.val + temp;
            int sum = num%10;
            node.next = new ListNode(sum );
            node = node.next;
            temp = num /10;
            l1 = l1.next;
        }
        while (l2!=null){
            int num = l2.val + temp;
            int sum = num%10;
            node.next = new ListNode(sum );
            node = node.next;
            temp = num /10;
            l2 = l2.next;
        }

        if (temp>0){
            node.next = new ListNode(temp);
        }
        return pre.next;
    }

    class ListNode {
       int val;
       ListNode next;
       ListNode() {}
       ListNode(int val) { this.val = val; }
       ListNode(int val, ListNode next) { this.val = val; this.next = next; }
   }
}
