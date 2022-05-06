package mytx.class03;

/**
 * 数组实现栈和队列
 */
public class Code04_RingArray {
    //
    public static class MyQueue {
        private int[] arr;
        private int pushI;
        private int popI;
        private int size;
        private int limit;

        MyQueue(int[] arr, int limit) {
            this.pushI = 0;
            this.popI = 0;
            this.size = 0;
            this.limit = limit;
            this.arr = new int[limit];
        }

        public int pop() {
            if (size == 0) {
                throw new RuntimeException("empty");
            }

            int t = arr[popI];
            popI = getNext(popI);
            size--;
            return t;
        }

        public void push(int val) {
            if (size == limit) {
                throw new RuntimeException("full");
            }
            arr[pushI] = val;
            pushI = getNext(pushI);
            size++;
        }

        public int getNext(int i) {
            return i < limit - 1 ? size + 1 : 0;
        }

    }
}

