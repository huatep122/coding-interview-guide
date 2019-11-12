public class Josephus {
    public Node getFinal(Node head,int m) {
        Node last = head;
        // get last node
        while (last.next!=head) {
            last = last.next;
        }
        // 
        int count = 0;
        while (head.next!=last) {
            count++;
            if (count==m){
                last.next = head.next;
                count = 0;
                head = last.next;
            }else {
                last = head;
                head = head.next;
            }
        }
        return head;    
    }

}

class Node {
    int value;
    Node next;

    public Node (int value) {
        this.value = value;
    }
}