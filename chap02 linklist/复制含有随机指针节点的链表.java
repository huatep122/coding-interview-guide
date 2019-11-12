public class 复制含有随机指针节点的链表 {
    /*
     * 第一想法是，用HashMap保存原链表中随机指针的对应关系，但是此时新链表却无法得知自己的对应关系，因为找不到随机指针指向的点
     * 所以，应该保存原链表节点和新链表节点之间的对应关系。1-1' 2-2' 3-3'
     */
    public Node copyListWithRand1(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node p = head;
        Node p_ = null;
        while (p != null) {
            p_ = new Node(p.value);
            map.put(p, p_);
            p = p.next;
        }
        p = head;
        while (p != null) {
            p_ = map.get(p);
            p_.next = map.get(p.next);
            p_.rand = map.get(p.rand);
            p = p.next;
        }
        return map.get(head);
    }

    /*
     * 在链表的每一个节点后做一份复制，1-1'-2-2'-3-3' 这样也相当于绑定了原链表节点和新链表节点。只不过没有使用map
     */
    public Node copyListWithRand2(Node head) {
        // 添加新节点
        Node p = head;
        Node next = null;
        while (p != null) {
            next = p.next;
            Node node = new Node(p.value);
            node.next = next;
            p.next = node;
            p = next;
        }
        // 更新rand
        p = head;
        while (p != null) {
            p.next.rand = p.rand == null ? null : p.rand.next;
            p = p.next.next;
        }
        // 捡出新链表的节点
        p = head.next;
        while (p != null) {
            next = p.next == null ? null : p.next.next;
            p.next = next;
            p = next;
        }
        return head.next;
    }

}

class Node {
    int value;
    Node next;
    Node rand;

    public Node(int value) {
        this.value = value;
    }
}