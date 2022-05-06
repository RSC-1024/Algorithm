package mytx.class03;

import tixixuexi.class03.Code02_DeleteGivenValue;

public class class03_Remove {
    public static class Node {
        Node next;
        int val;

        public Node(int val) {
            this.val = val;
        }

    }


    //把链表中的给定值都删除


    // head = removeValue(head, 2);
    public static Code02_DeleteGivenValue.Node removeValue(Code02_DeleteGivenValue.Node head, int num) {
        // head来到第一个不需要删的位置
        // 返回的是while之后的节点
        while (head != null) {
            if (head.value != num) {
                break;
            }
            head = head.next;
        }
        // 1 ) head == null
        // 2 ) head != null
        Code02_DeleteGivenValue.Node pre = head;
        Code02_DeleteGivenValue.Node cur = head;
        while (cur != null) {
            if (cur.value == num) {
                //这个地方有点绕。
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }

}



