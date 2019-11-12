public class 链表回文结构 {
    // 方法一，使用一个栈
    public boolean isPalindrome1(Node head) {
        Stack<Node> stack = new Stack<>();
        Node p = head;
        while (p != null) {
            stack.push(p);
            p = p.next;
        }
        while (head != null) {
            if (stack.pop().value != head.value)
                return false;
            head = head.next;
        }
        return true;
    }

    // 方法二，使用栈压入一半元素，此时用快慢指针找到中间靠右的元素
    public boolean isPalindrome2(Node head) {
        Stack<Node> stack = new Stack<>();
        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        Node p = slow;
        while (p != null) {
            stack.push(p);
            p = p.next;
        }
        while (!stack.empty() && head != slow) {
            if (stack.pop().value != head.value) {
                return false;
            }
            head = head.next;
        }
        return true;
    }
    // 方法三，不使用栈结构，快慢指针找到中间靠左结点（因为下一结点要指向它，所以应该定位到他），将右侧逆序。从两头向中间走
    public boolean isPalindrome3(Node head) {
        Stack<Node> stack = new Stack<>();
        Node fast = head;
        Node slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // 此时slow指向了所有需要翻转的左边一个
        Node cur = slow.next;
        slow.next = null;
        Node next;
        while (cur != null) {
            next = cur.next;
            cur.next = slow;
            slow = cur;
            cur = next;
        }

        while (head != null && slow != null) {
            if (head.value != slow.value) {
                return false;
            }
            head = head.next;
            slow = slow.next;
        }
        return true;
    }
}

class Node {
    int value;
    Node next;

    public Node(int value) {
        this.value = value;
    }
}