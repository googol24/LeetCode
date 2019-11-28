public class RecorderList {

    static ListNode nodeHelp = new ListNode(0);

    public static void main(String args[]) {
        // 建立单链表
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);
        ListNode node8 = new ListNode(8);

        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;

        nodeHelp.printList(head);

        recoderList(head);

        nodeHelp.printList(head);
    }

    public static void recoderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        // 折半找到中点，中点后面的链表就地逆置，然后合并
        // 1,2,3,4,5,6,7,8 -> 1,2,3,4,8,7,6,5 -> 1,8,2,7,3,6,4,5
        ListNode fast = head, slow = head;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode second = slow.next;
        slow.next = null;

        // 头插法就地逆置第二段单链表
        ListNode next = null;
        while (second != null) {
            ListNode tmpNode = second.next;
            second.next = next;
            next = second;
            second = tmpNode;
        }

        // 合并
        ListNode first = head;
        while (first != null && next != null) {
            ListNode firstN = first.next;
            ListNode nextN = next.next;

            first.next = next;
            first = firstN;

            next.next = first;
            next = nextN;
        }
    }
}
