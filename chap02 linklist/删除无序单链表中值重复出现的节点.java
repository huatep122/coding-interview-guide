import java.util.Set;

public class 删除无序单链表中值重复出现的节点 {
    // 使用HashSet记录元素重复
    public void removeRepeatNode(Node head) {
        if (head == null)
            return;
        Set<Integer> set = new HashSet<>();
        Node cur = head.next;
        Node prev = head;
        set.add(head.value);
        while (cur != null) {
            if (set.contains(cur.value)) {
                prev.next = cur.next;
            } else {
                set.add(cur.value);
                prev = cur;
            }
            cur = cur.next;
        }
    }

    // 每轮选取一个元素的值，在后面查找是否有相同的。删除完后选择下一个节点继续
    public void removeRepeatNode1(Node head) {
        Node p = head;
        Node pre = null;
        Node cur = null;
        while (p != null) {
            cur = p.next;
            pre = p;
            while (cur != null) {
                if (cur.value == p.value) {
                    pre.next = cur.next;
                } else {
                    pre = cur;
                }
                cur = cur.next;
            }
            p = p.next;
        }
    }
}

class Node {
    int value;
    Node next;

    public Node(int value) {
        this.value = value;
    }
}