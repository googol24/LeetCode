// 在O(n log n)的时间内使用常数级空间复杂度对链表进行排序。

/**
 * 链表结点类
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        this.val = x;
        this.next = null;
    }

    public ListNode sortList(ListNode head) {
        // 空链表或者只有一个结点的链表
        if (head == null || head.next == null) {
            return head;
        }

        ListNode first = head;
        ListNode second = null;

        // 使用折半归并排序
        ListNode middleNode = this.getMiddleNode(first);

        // 链表从中间折断
        second = middleNode.next;
        middleNode.next = null;

        // 递归
        first = sortList(first);
        second = sortList(second);

        // 合并
        return merge(first, second);

    }

    private ListNode getMiddleNode(ListNode head) {

        ListNode fast = head;
        ListNode slow = head;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    // 对两个有序链表进行合并
    private ListNode merge(ListNode first, ListNode second)
    {
        if (first == null) {
            return second;
        }

        if (second == null) {
            return first;
        }

        ListNode result = new ListNode(0);
        ListNode current = result;

        while (first != null && second != null) {
            if (first.val <= second.val) {
                current.next = first;
                current = current.next;
                first = first.next;
            } else {
                current.next = second;
                current = current.next;
                second = second.next;
            }
        }

        // 处理没有比较完的剩余链表结点数据
        if (first != null) {
            current.next = first;
        }

        if (second != null) {
            current.next = second;
        }

        return result.next;
    }

    public void printList(ListNode head) {
        ListNode node = head;

        System.out.println();
        System.out.print("list:");

        while (node != null) {
            System.out.print(node.val);
            System.out.print("->");
            node = node.next;
        }

        System.out.print("NULL");
    }
}

public class SortList {
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

        head = nodeHelp.sortList(head);

        nodeHelp.printList(head);
    }
}
