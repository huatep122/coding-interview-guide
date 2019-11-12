public class ReversePartial {
    // public Node reverse(Node head, int from, int to) {
    // Node pre = null;
    // Node toNext = null;
    // Node p = head;
    // int count1 = 1;
    // while (p!=null&& count1<from){
    // pre = p;
    // p=p.next;
    // count1++;
    // }
    // int count2 = 1;
    // p = head;
    // while (p!=null&&count2<to) {
    // p=p.next;
    // }
    // toNext = p.next;

    // Node begin = pre.next;
    // Node end = begin;
    // p = begin.next;
    // while (p!=toNext) {
    // end.next = p.next;
    // p.next = begin;
    // pre.next = p;
    // p=end.next;
    // }

    // return head;
    // }

    public Node reverse(Node head, int from, int to) {
        Node fromPre = null;
        Node toPost = null;
        int counter = 0;
        Node p = head;
        while (p != null) {
            counter++;
            fromPre = counter == from - 1 ? p : fromPre;
            toPost = counter == to + 1 ? p : toPost;
            p = p.next;
        }
        // found the pre and the post

        if (from > to || from < 1 || to > counter) {
            return head;
        }
        // the role of head
        Node node1 = fromPre == null ? head : fromPre.next;
        // 
        Node node2 = node1.next;
        node1.next = toPost;
        Node next = null;
        while (node2 != toPost) {
            next = node2.next;
            node2.next = node1;
            node1 = node2;
            node2 = next;
        }
        if (fromPre != null) {
            fromPre.next = node1;
            return head;
        }else {
            return node1;
        }
    }
}

class Node {
    public int value;
    public Node next;

    public Node(int value) {
        this.value = value;
    }
}
