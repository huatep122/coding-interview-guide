public class 将单链表的每K个节点之间逆序 {

    // 方法一，借助栈
    public Node getResult(Node head) {
        int k = 0;
        Node newHead = new Node(-1);
        Node last = newHead;
        Stack<Node> s = new Stack<>();
        while (true) {
            while (k != 3 && head != null) {
                s.push(head);
                head = head.next;
                k++;
            }
            if (k == 3) {// insert at last
                while (!s.empty()) {
                    Node pop = s.pop();
                    pop.next = null;
                    last.next = pop;
                    last = last.next;
                }
                k = 0;
            } else {// insert at head
                while (!s.empty()) {
                    Node pop = s.pop();
                    pop.next = last.next;
                    last.next = pop;
                }
                break;
            }
        }
        return newHead.next;
    }

    // 方法二，直接翻转
    public Node getResult1(Node head) {
        int k = 1;
        Node pre = null;
        Node next = null;
        Node start = null;
        Node cur = head;
        while (cur != null) {
            next = cur.next;
            if (k == 3) {
                start = pre == null ? head : pre.next;
                head = pre == null ? cur : head;// 对前三个元素翻转，头结点应该变为第三个元素。，之后的翻转不需要再改变head
                reverseList(pre, start, cur, next);
                pre = start;
                k = 0;
            }
            cur = next;
            k++;
        }
        return head;
    }

    void reverseList(Node left, Node start, Node end, Node right) {
        Node pre = start;
        Node cur = start.next;
        Node next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        if (left != null) {
            left.next = end;
        }
        start.next = right;
    }

}

class Node {
    int value;
    Node next;

    public Node(int value) {
        this.value = value;
    }
}