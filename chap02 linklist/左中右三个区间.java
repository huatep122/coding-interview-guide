public class 左中右三个区间 {
    public Node listPartition(Node head, int pivot) {
        Node sH = null;
        Node sT = null;
        Node eH = null;
        Node eT = null;
        Node bH = null;
        Node bT = null;

        while (head != null) {
            if (head.value < pivot) {// 尾插入s链表
                if (sH == null) {
                    sh = head;
                    sT = head;
                } else {
                    sT.next = head;
                    sT = sT.next;
                }
            } else if (head.value == pivot) {// 尾插入e链表
                if (eH == null) {
                    eh = head;
                    eT = head;
                } else {
                    eT.next = head;
                    eT = eT.next;
                }
            } else {// 尾插入b链表
                if (bH == null) {
                    bh = head;
                    bT = head;
                } else {
                    bT.next = head;
                    bT = bT.next;
                }
            }
            head = head.next;
        }
        // 合并三个链表
        if (sT != null) {// 拼接s的尾部和e的头部
            sT.next = eH;
            eT = eT == null ? sT : eT;// 对e的尾部做预处理，当eT==null时，说明e为空，拼接s和b。
        }
        if (eT != null) {// 拼接e和b
            eT.next = bT;
        }
        bT.next = null;
        return sH != null ? sH : eH != null ? eH : bH;
    }
}

class Node {
    int value;
    Node next;

    public Node(int value) {
        this.value = value;
    }
}