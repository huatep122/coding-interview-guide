public class 合并两个有序的单链表 {
    public Node merge(Node head1, Node head2) {
        Node newHead = new Node(-1);
        Node tail = newHead;
        while (head1 != null && head2 != null) {
            if (head1.value < head2.value) {
                tail.next = head1;
                tail = head1;
                head1 = head1.next;   
            }else {
                tail.next = head2;
                tail = head2;
                head2 = head2.next;
            }
        }
        if (head1 != null) tail.next = head1;
        if (head2 != null) tail.next = head2;
        return newHead.next;
    }

}

class Node {
    int value;
    Node next;

    public Node(int value) {
        this.value = value;
    }
}