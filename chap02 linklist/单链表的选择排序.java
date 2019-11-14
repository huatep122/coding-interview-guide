public class 单链表的选择排序 {
    public Node selectionSort(Node head) {
        Node newHead = new Node(-1);
        Node tail = newHead;
        Node p = head;
        Node smallPre=null;
        Node small = null;
        while (p != null) {
            // get small pre node
            smallPre = getSmallPrevious(p);
            // get small node
            small = smallPre==null ? p :smallPre.next;
            //delete small node from origin list
            if (smallPre==null){// first node
                p = p.next;
            }else{// inter node
                smallPre.next = small.next;
            }
            tail.next = small;
            tail = tail.next;
        }
        return newHead.next;
    }
    
    public Node getSmallPrevious(Node head) {
        Node pre=head;
        Node cur=head.next;
        Node small = head;
        Node smallPre=null;
        while (cur!=null) {
            if (cur.value<small.value) {
                small = cur;
                smallPre = pre;
            }
            pre = cur;
            cur = cur.next;
        }
        return smallPre;
    }
    
}

class Node {
    int value;
    Node next;
    public Node(int value) {
        this.value = value;
    }
}
