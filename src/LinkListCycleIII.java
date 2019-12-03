import java.util.*;

class LinkListNode {
    String data;
    LinkListNode next;

    LinkListNode(String str) {
        this.data = str;
        this.next = null;
    }
}

public class LinkListCycleIII {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String str = scanner.nextLine();

        // 不能超过255位
        if (str.length() > 255) {
            str = str.substring(0, 255);
        }

        LinkListNode head = createList(str);

        String cycleHeadValue = getCycleFirstNode(head);

        System.out.println(cycleHeadValue);

    }

    // 根据字符串建立链表（不一定是循环链表）
    private static LinkListNode createList(String str) {
        LinkListNode head = null;
        LinkListNode tmpNode = null;

        // 用于判断结点是否出现过
        ArrayList<String> map = new ArrayList<String>();

        for (int i = 0; i < str.length(); i++) {
            String value = str.substring(i, i + 1);
            LinkListNode node = new LinkListNode(value);

            // 判断是否出现
            if (map.contains(value)) {
                // 出现环
                if (tmpNode != null) {
                    LinkListNode pointer = head;
                    while (pointer != null) {
                        if (pointer.data.equals(value)) {
                            tmpNode.next = pointer;
                            return head;
                        }

                        pointer = pointer.next;
                    }
                }

            } else {
                // 标记
                map.add(value);

                // 建立链表
                if (head == null) {
                    head = node;
                    tmpNode = head;
                } else {
                    tmpNode.next = node;
                    tmpNode = node;
                }
            }
        }

        return head;
    }

    // 获取环的首节点，不存在则返回"0"
    private static String getCycleFirstNode(LinkListNode head) {
        if (head == null || head.next == null) {
            return "0";
        }

        LinkListNode fast = head, slow = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (fast == slow) {
                // 相遇，则有环
                LinkListNode node1 = head;
                LinkListNode node2 = fast;

                while (node1 != node2) {
                    node1 = node1.next;
                    node2 = node2.next;
                }

                return node1.data;
            }
        }

        return "0";
    }
}
