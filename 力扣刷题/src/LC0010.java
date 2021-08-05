/**
 * 19.删除链表的倒数第N个结点
 */
public class LC0010 {
    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n == 0) return head;
        ListNode preHead = new ListNode(0);
        preHead.next = head;
        ListNode first = preHead,second = preHead;
        for (int i = 0;i<n;i++){
            first = first.next;
            if (first == null )
                return head;
        }
        while (first.next!=null){
            first = first.next;
            second = second.next;
        }
        second.next= second.next.next;
        return preHead.next;
    }

}
