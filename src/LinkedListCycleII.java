public class LinkedListCycleII {

    public static void main(String[] args) {
        // 单链表1 - 无环
        ListNode head1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);

        head1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        // 单链表2 - 有环
        ListNode head2 = new ListNode(7);
        ListNode node8 = new ListNode(8);
        ListNode node9 = new ListNode(9);
        ListNode node10 = new ListNode(10);
        ListNode node11 = new ListNode(11);

        head2.next = node8;
        node8.next = node9;
        node9.next = node10;
        node10.next = node11;
        node11.next = node9;

        System.out.println(checkCycle(head1));
        System.out.println(checkCycle(head2));
    }

    public static ListNode checkCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode fast = head, slow = head;

        while (slow.next != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (fast == slow) {
                // 相遇，设定两个指针，一个从链表起始结点开始，一个从相遇结点开始
                // 每次走一步，相遇的结点即是环的起点
                ListNode node1 = head;
                ListNode node2 = fast;

                while (node1 != node2) {
                    node1 = node1.next;
                    node2 = node2.next;
                }

                return node1;
            }
        }

        return null;
    }
}
