package mytx.class03;


import java.util.LinkedList;
import java.util.Queue;

public class Code07_TwoQueueImplementStack {
    public static class TwoQueueStack<T> {
        Queue<T> queue;
        Queue<T> help;

        public TwoQueueStack() {
            this.queue = new LinkedList();
            this.help = new LinkedList();
        }

        public T pop() {
            while (this.queue.size() > 1) {
                this.help.offer(this.queue.remove());
            }
            //fix: 两个队列不停交换 没想到。交换后思路清晰，不用考虑两边的情况。认准每次目标都是要从Queue里拿数据，实际都是把其他数据先倒倒help里留下最后一个
            T ans = queue.remove();
            Queue tmp = queue;
            this.queue = help;
            help = queue;
            return ans;
        }

        public void push(T t) {
            this.queue.offer(t);
        }

        public boolean isEmpty() {
            return this.queue.isEmpty();
        }

    }
}
