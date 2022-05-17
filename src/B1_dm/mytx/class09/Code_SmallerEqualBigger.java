package mytx.class09;

import tixixuexi.class09.Code03_SmallerEqualBigger;

public class Code_SmallerEqualBigger {
    public static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public static Node getSmallerEqualBigger(Node head, int target) {
        if (head == null) {
            return null;
        }

        Node sH = null;
        Node sT = null;
        Node eH = null;
        Node eT = null;
        Node bH = null;
        Node bT = null;

        Node cur = head;
        while (cur != null) {
            if (cur.value < target) {
                if (sH == null) {
                    sH = cur;
                    sT = cur;
                } else {
                    sT.next = cur;
                    sT = sT.next;
                }
            } else if (cur.value == target) {
                if (eH == null) {
                    eH = cur;
                    eT = cur;
                } else {
                    eT.next = cur;
                    eT = eT.next;
                }
            } else {
                if (bH == null) {
                    bH = cur;
                    bT = cur;
                } else {
                    bT.next = cur;
                    bT = bT.next;
                }
            }
            //note 忘了把这一点清空
            Node tmp = cur.next;
            cur.next=null;
            cur = tmp;
        }


        Node ans = sH != null ? sH : (eH != null ? eH : bH);
        if (sT != null) {
            sT.next = eH != null ? eH : bH;
        }
        if (eT != null) {
            eT.next = bH;
        }
        return ans;
    }

    //copy for test

    public static void main(String[] args) {
        Node head1 = new Node(7);
        head1.next = new Node(9);
        head1.next.next = new Node(1);
        head1.next.next.next = new Node(8);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(2);
        head1.next.next.next.next.next.next = new Node(5);
        printLinkedList(head1);
        // head1 = listPartition1(head1, 4);
        head1 = getSmallerEqualBigger(head1, 5);
        printLinkedList(head1);

    }


    public static void printLinkedList(Node node) {
        System.out.print("Linked List: ");
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }

}
