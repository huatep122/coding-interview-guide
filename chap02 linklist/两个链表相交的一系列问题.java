public class 两个链表相交的一系列问题 {
    // 返回环开始的第一个节点，没有返回null
    public Node getLoopNode(Node head) {
        Node p = head;
        Map<Node, Boolean> map = new HashMap<>();
        while (p != null) {
            map.put(p, true);
            if (map.get(p.next) != null && map.get(p.next) == true) {
                return p.next;
            }
            p = p.next;
        }
        return null;
    }

    // 返回两个无环单链表第一个相交节点
    public Node noLoop(Node head1, Node head2) {
        Node p1 = head1;
        Node p2 = head2;
        int len1 = 0;
        int len2 = 0;
        while (p1 != null) {
            len1++;
            p1 = p1.next;
        }
        while (p2 != null) {
            len2++;
            p2 = p2.next;
        }
        // 如果两个链表最后一个节点都不相交，那么说明它们不相交
        if (p1 != p2)
            return false;
        p1 = head1;
        p2 = head2;
        // 将p1,p2放到同一起跑线
        int n = len1 > len2 ? len1 - len2 : len2 - len1;
        if (len1 > len2) {
            while (n != 0) {
                p1 = p1.next;
                n--;
            }
        } else if (len2 > len1) {
            while (n != 0) {
                p2 = p2.next;
                n--;
            }
        }
        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }

    // 返回两个有环单链表的第一个相交
    public Node twoLoop(Node head1, Node head2) {
        // 先获得两个环的入环节点。
        Node loop1 = getLoopNode(head1);
        Node loop2 = getLoopNode(head2);
        // 分两种情况，若两个环不相交，那么它们的入环点不在彼此的遍历序列中，遍历链表1，若loop2不在其中则不相交
        // 若两个环相交，那么有两种可能，一种是在入环之前相交（那么此时loop1==loop2），一种是在环上相交（包括入环点）
        if (loop1 == loop2) {
            Node p1 = head1;
            Node p2 = head2;
            int len1 = 0;
            int len2 = 0;
            while (p1 != loop1) {
                len1++;
                p1 = p1.next;
            }
            while (p2 != loop2) {
                len2++;
                p2 = p2.next;
            }

            p1 = head1;
            p2 = head2;
            // 将p1,p2放到同一起跑线
            int n = len1 > len2 ? len1 - len2 : len2 - len1;
            if (len1 > len2) {
                while (n != 0) {
                    p1 = p1.next;
                    n--;
                }
            } else if (len2 > len1) {
                while (n != 0) {
                    p2 = p2.next;
                    n--;
                }
            }
            while (p1 != p2) {
                p1 = p1.next;
                p2 = p2.next;
            }
            return p1;
        } else {
            p1 = loop1.next;
            while (p1 != loop1) {
                if (p1 == loop2) {
                    return p1;
                }
                p1 = p1.next;
            }
            return null;
        }
    }

    public Node getNode(Node head1, Node head2) {
        Node loop1 = getLoopNode(head1);
        Node loop2 = getLoopNode(head2);
        if (loop1 == null && loop2 == null)
            return noLoop(head1, head2);
        else if (loop1 != null && loop2 != null)
            return twoLoop(head1, head2);
        else
            return null;
    }

}

class Node {
    int value;
    Node next;

    public Node(int value) {
        this.value = value;
    }
}