// 使用插入排序对链表进行排序

public class InsertionSortList {
    private static ListNode nodeHelp = new ListNode(0);

    public static void main(String[] args) {
        // 建立单链表
        ListNode head = new ListNode(2);
        ListNode node1 = new ListNode(1);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);

        node6.next = node4;
        node1.next = node6;
        node7.next = node1;
        node3.next = node7;
        node5.next = node3;
        head.next = node5;

        nodeHelp.printList(head);

        ListNode sortList = insertSort(head);

        nodeHelp.printList(sortList);
    }

    // 插入排序
    public static ListNode insertSort(ListNode head) {
        // 空链表或者只有一个结点的链表
        if (head == null || head.next == null) {
            return head;
        }

        // 直接插入排序
        ListNode curNode = head.next;
        ListNode pNode = new ListNode(0);
        pNode.next = head;
        head.next = null;

        while (curNode != null) {
            ListNode compareNode = pNode;
            while (compareNode != null) {
                if (compareNode.next == null || compareNode.next.val >= curNode.val) {
                    break;
                }
                compareNode = compareNode.next;
            }

            ListNode temp = curNode.next;
            curNode.next = compareNode.next;
            compareNode.next = curNode;
            curNode = temp;
        }

        return pNode.next;
    }
}
