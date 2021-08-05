/**
 * 21. 合并两个有序链表
 *  将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 */
public class LC0012 {
    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode node1 = l1,node2 = l2,node = head;
        while (node1!=null && node2!=null) {
            if (node1.val > node2.val) {
                node.next = node2;
                node2 = node2.next;
            } else {
                node.next = node1;
                node1 = node1.next;
            }
            node = node.next;
        }

        if (node1!=null)
            node.next = node1;
        if (node2!=null)
            node.next = node2;

        return head.next;
    }
}
