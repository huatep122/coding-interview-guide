public class 两个单链表生成相加链表 {
    // 借助两个栈
    public Node addList1(Node head1, Node head2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        Node p1 = head1;
        Node p2 = head2;
        while (p1 != null) {
            s1.push(p1.value);
            p1 = p1.next;
        }
        while (p2 != null) {
            s2.push(p2.value);
            p2 = p2.next;
        }

        int cal = 0;
        int n1 = 0;
        int n2 = 0;
        int curSum = 0;
        Node head = new Node(-1);
        while (!s1.empty() && !s2.empty()) {
            n1 = s1.pop();
            n2 = s2.pop();
            curSum = cal + n1 + n2;
            Node node = new Node(curSum % 10);
            node.next = head.next;
            head.next = node;
            cal = curSum / 10;
        }
        if (!s1.empty()) {
            while (!s1.empty()) {
                n1 = s1.pop();
                curSum = n1 + cal;
                Node node = new Node(curSum % 10);
                node.next = head.next;
                head.next = node;
                cal = curSum / 10;
            }
        }
        if (!s2.empty()) {
            while (!s2.empty()) {
                n1 = s2.pop();
                curSum = n2 + cal;
                Node node = new Node(curSum % 10);
                node.next = head.next;
                head.next = node;
                cal = curSum / 10;
            }
        }
        if (cal != 0) {
            Node node = new Node(1);
            node.next = head.next;
            head.next = node;
        }
        return head.next;
    }
    // 先将两个链表翻转，从前向后每位相加
    public Node addList2(Node head1, Node head2) {
        head1 = reverse(head1);
        head2 = reverse(head2);
        int cal = 0;
        Node head = new Node(-1);
        int curSum = 0;
        int n1 = 0;
        int n2 = 0;
        Node c1 = head1;
        Node c2 = head2;
        while (c1 != null || c2 != null) {
            n1 = c1 == null ? 0 : c1.value;
            n2 = c2 == null ? 0 : c2.value;
            curSum = n1 + n2 + cal;
            Node node = new Node(curSum % 10);
            node.next = head.next;
            head.next = node;
            cal = curSum / 10;
            c1 = c1 == null ? null : c1.next;
            c2 = c2 == null ? null : c2.next;
        }
        if (cal != 0) {
            Node node = new Node(1);
            node.next = head.next;
            head.next = node;
        }
        reverse(head1);
        reverse(head2);
        return head;
    }

    public Node reverse(Node head) {
        Node prev = null;
        Node next = null;
        while (head != null) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}

class Node {
    int value;
    Node next;

    public Node(int value) {
        this.value = value;
    }
}