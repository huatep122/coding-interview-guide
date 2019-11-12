public class ReverseList {
    // method1 Head insertion
    public Node reverse(Node head) {
        if (head == null)
            return null;
        Node p = head;
        Node cur = p;
        head = null;
        while (p != null) {
            cur = p;
            p = p.next;
            cur.next = head;
            head = cur;
        }
        return head;
    }

    // method2
    public Node reverse1(Node head) {
        Node pre = null;
        Node next = null;
        // Node p = head.next;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}

class Node {
    public int value;
    public Node next;

    public Node(int value) {
        this.value = value;
    }
}
