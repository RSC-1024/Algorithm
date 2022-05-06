package mytx.class06;

import tixixuexi.class06.Code02_Heap;

import java.util.PriorityQueue;

public class Code01_Heap {
    public static class MaxHeap {
        //note : 不是 int[] heap[];
        int[] heap;
        int heapSize;
        //note: limit 不是index 体会含义
        int limit;
        //note :初始化

        MaxHeap(int limit) {
            this.heap = new int[limit];
            this.limit = limit;
            this.heapSize = 0;
        }

        public void push(int x) {
            if (heapSize == limit) {
                throw new RuntimeException("heap is full");
            }
            //先把数放在最后
            heap[heapSize] = x;
            //最后一个数开始调整
            heapInsert(heap, heapSize++);
        }

        //先放在堆底 然后逐次比较大小
        public void heapInsert(int[] arr, int index) {
            while (arr[index] > arr[(index - 1) / 2]) {
                swap(arr, index, (index - 1) / 2);
                index = (index - 1) / 2;
            }
        }

        private void swap(int[] arr, int index, int i) {
            int tmp = arr[i];
            arr[i] = arr[index];
            arr[index] = tmp;
        }
        //
        public int pop(){
            if (heapSize==0){
                throw new RuntimeException("heap is empty");
            }
            int target=heap[0];
            //把该移除的数放在最后去。然后让数组脱离管理这个位置
            //note : heapSize 比index 大1 。用的时候注意，最后一个元素是 heap[heapSize-1]
            swap(heap,0,--heapSize);

            //从0开始，从上到下调整。把末位来的数据再重新排好
            heapily(heap,0);
            return target;
        }

        private void heapily(int[] heap, int i) {
            int left = i*2+1;
            while(left<heapSize ){
                // note :maxSon 是索引位置，不是数！  ?heap[left+1]:heap[left]是错的
                int maxSon= (left+1<heapSize && heap[left+1]>heap[left])?left+1:left;
                if (heap[maxSon]<=heap[i]){
                    break;
                }
                swap(heap,i,maxSon);
                //heapily(heap,maxSon);
                //note:index 和 maxSon位置都要移动 ,这一步不能忘
                i=maxSon;
                left = i*2+1;
            }
        }

        public boolean isEmpty() {
            return heapSize==0;
        }

        public boolean isFull() {
            return heapSize==limit;
        }
    }

    // copy from demo
    public static void main(String[] args) {

        // 小根堆
        PriorityQueue<Integer> heap = new PriorityQueue<>(new Code02_Heap.MyComparator());
        heap.add(5);
        heap.add(5);
        heap.add(5);
        heap.add(3);
        // 5 , 3
        System.out.println(heap.peek());
        heap.add(7);
        heap.add(0);
        heap.add(7);
        heap.add(0);
        heap.add(7);
        heap.add(0);
        System.out.println(heap.peek());
        while (!heap.isEmpty()) {
            System.out.println(heap.poll());
        }

        int value = 1000;
        int limit = 100;
        int testTimes = 1000000;
        for (int i = 0; i < testTimes; i++) {
            int curLimit = (int) (Math.random() * limit) + 1;
            MaxHeap my = new MaxHeap(curLimit);
            Code02_Heap.RightMaxHeap test = new Code02_Heap.RightMaxHeap(curLimit);
            int curOpTimes = (int) (Math.random() * limit);
            for (int j = 0; j < curOpTimes; j++) {
                if (my.isEmpty() != test.isEmpty()) {
                    System.out.println("1Oops!");
                }
                if (my.isFull() != test.isFull()) {
                    System.out.println("2Oops!");
                }
                if (my.isEmpty()) {
                    int curValue = (int) (Math.random() * value);
                    my.push(curValue);
                    test.push(curValue);
                } else if (my.isFull()) {
                    if (my.pop() != test.pop()) {
                        System.out.println("3Oops!");
                    }
                } else {
                    if (Math.random() < 0.5) {
                        int curValue = (int) (Math.random() * value);
                        my.push(curValue);
                        test.push(curValue);
                    } else {
                        if (my.pop() != test.pop()) {
                            System.out.println("4Oops!");
                        }
                    }
                }
            }
        }
        System.out.println("finish!");

    }

}
