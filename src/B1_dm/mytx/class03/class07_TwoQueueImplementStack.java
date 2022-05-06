package mytx.class03;

/**
 * 双向链表实现栈和队列
 *
 */
public class class07_TwoQueueImplementStack {
    public static class MyQueue {
        MyQueue pre;
        MyQueue next;
        int val;

        MyQueue(int val) {
            this.val = val;
        }
    }

}
