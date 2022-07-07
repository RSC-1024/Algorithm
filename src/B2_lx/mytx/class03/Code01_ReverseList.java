package B2_lx.mytx.class03;

import java.util.ArrayList;
import java.util.List;

/**
 * @title: Algorithm
 * @description: 反转链表
 * @author: Lucy
 * @date: 2022/05/25 15:35
 */
public class Code01_ReverseList {
    public static class Node{
        public Integer value;
        public Node next;

        public Node(Integer value) {
            this.value = value;
        }
    }

    /**
     * 反转单向链表
     * head
     * a    ->   b    ->  c  ->  null
     * c    ->   b    ->  a  ->  null
     * @param head
     * @return
     */
    public static Node reverseLinkedList(Node head){
        if (head ==null || head.next == null){
            return head;
        }
        Node pre = null;
        Node next = null;
        while (head != null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    /**
     * 用集合方式 实现反转单链表
     * @param head
     * @return
     */
    public static Node testReverseLinkedList(Node head){
        if (head ==null || head.next == null){
            return head;
        }
        List<Node> list = new ArrayList<>();
        while (head != null){
            list.add(head);
            head = head.next;
        }
        for (int i = 1; i < list.size(); i++) {
            list.get(i).next = list.get(i-1);
        }
        return list.get(list.size()-1);
    }
    public static Node generateLinkedList(int len, int val){
        // [0,len] 范围内的整数，等概率返回一个。
        int size = (int) (Math.random() * (len+1));
        Node head = new Node((int) (Math.random() * (val+1)));
        Node pre = head;
        
        while (size >0){
            Node cur = new Node((int) (Math.random() * (val+1)));
            pre.next = cur;
            pre = cur;
            size --;
        }
        return head;
    }
    public static void main(String[] args) {
        Node node = generateLinkedList(5, 9);
        while (node !=null){
            System.out.println(node.value);
            node = node.next;
        }        
        /*Node node = new Node(5);
        node.next = new Node(3);
        node.next.next= new Node(7);
        node.next.next.next = new Node(2);
        //while (node !=null){
        //    System.out.println(node.value);
        //    node = node.next;
        //}
        Node result = reverseLinkedList(node);
        while (result !=null ){
            System.out.println(result.value);
            result = result.next;
        }*/
    }
}
