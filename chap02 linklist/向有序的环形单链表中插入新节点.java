public class 向有序的环形单链表中插入新节点 {
    public Node insertNode(Node head, int num) {
        Node node = new Node(num);
        Node cur = head.next;
        Node pre = head;
        while (cur != head) {
            if (pre.value <= num && cur.value >= num) {
                node.next = cur;
                pre.next = node;
                break;
            }
            pre = cur;
            cur = cur.next;
        }
        if (cur == head) {
            node.next = head;
            pre.next = node;
        }
        return head.value < num ? head : node;
    }

}

class Node {
    int value;
    Node next;

    public Node(int value) {
        this.value = value;
    }
}