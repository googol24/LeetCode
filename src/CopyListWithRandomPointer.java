/**
 * 随机链表节点类
 */
class RandomListNode {
    int label;
    RandomListNode next, random;

    RandomListNode(int x) {
        this.label = x;
    }

    public void printList(RandomListNode node) {
        RandomListNode tempNode = node;

        while (tempNode != null) {

            System.out.print("label:" + tempNode.label);
            System.out.print(",next:" + (tempNode.next == null ? "" : tempNode.next.label));
            System.out.print(",random:" + (tempNode.random == null ? "" : tempNode.random.label));
            System.out.println();

            tempNode = tempNode.next;
        }
    }
}

public class CopyListWithRandomPointer {
    private static RandomListNode randomListHelper = new RandomListNode(0);

    public static void main(String[] args) {
        RandomListNode head = new RandomListNode(1);
        RandomListNode node2 = new RandomListNode(2);
        RandomListNode node3 = new RandomListNode(3);
        RandomListNode node4 = new RandomListNode(4);

        head.next = node2;
        node2.next = node3;
        node3.next = node4;

        head.random = node3;
        node2.random = head;
        node3.random = node3;
        node4.random = null;

        randomListHelper.printList(head);
        RandomListNode copy = copyRandomList(head);
        System.out.println();
        randomListHelper.printList(copy);
    }

    // 深拷贝
    private static RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }

        // 先深拷贝新节点至旧结点的后面，然后把新节点从表中分离
        RandomListNode p = head;
        while (p != null) {
            RandomListNode copyNode = new RandomListNode(p.label);
            copyNode.next = p.next;
            p.next = copyNode;
            p = p.next.next;
        }

        // 再深拷贝random指针
        RandomListNode q = head;
        while (q != null && q.next != null) {
            RandomListNode newOld = q.next;
            if (q.random == null) {
                newOld.random = null;
            } else {
                newOld.random = q.random.next;
            }
            q = q.next.next;
        }

        // 拆表
        RandomListNode result = head.next;
        RandomListNode r = head, s = result;
        while (s != null) {
            r.next = s.next;
            r = s;
            s = s.next;
        }

        return result;
    }
}
