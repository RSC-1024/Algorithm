package mytx.class10;

public class class_GetIntersectionNode {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null){
            return null;
        }
        ListNode curA = headA;
        int lenA= 0;
        while (curA.next!=null){
            lenA++;
            curA= curA.next;
        }

        ListNode curB = headB;
        int lenB= 0;
        while (curB.next!=null){
            lenB++;
            curB= curB.next;
        }
        if(curA!=curB){
            return null;
        }
        curA= headA;
        curB = headB;
        int x =lenA - lenB;
        if(x>0){
            while(x>0){
                curA = curA.next;
                x--;
            }
        }
        if(x<0){
            while(x<0){
                curB = curB.next;
                x++;
            }
        }
        while(curA!=null && curB!= null){
            if (curB== curA){
                return curA;
            }
            curA = curA.next;
            curB = curB.next;
        }
        return null;
    }
}
