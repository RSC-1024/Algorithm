package mytx.class06;

public class Code01_HeapSort {

    public static class MaxHeap {
        public static void main(String[] args) {
            int[] arr = new int[]{5, 3, 6, 2, 9};
            sort(arr);
            for (int i = 0; i < arr.length; i++) {
                System.out.println(arr[i]);
            }
        }

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
        public static void heapInsert(int[] arr, int index) {
            while (arr[index] > arr[(index - 1) / 2]) {
                swap(arr, index, (index - 1) / 2);
                index = (index - 1) / 2;
            }
        }

        private static void swap(int[] arr, int index, int i) {
            int tmp = arr[i];
            arr[i] = arr[index];
            arr[index] = tmp;
        }

        //
        public int pop() {
            if (heapSize == 0) {
                throw new RuntimeException("heap is empty");
            }
            int target = heap[0];
            //把该移除的数放在最后去。然后让数组脱离管理这个位置
            //note : heapSize 比index 大1 。用的时候注意，最后一个元素是 heap[heapSize-1]
            swap(heap, 0, --heapSize);

            //从0开始，从上到下调整。把末位来的数据再重新排好
            heapily(heap, 0, heapSize);
            return target;
        }

        public static void heapily(int[] heap, int i, int heapSize) {
            int left = i * 2 + 1;
            while (left < heapSize) {
                // note :maxSon 是索引位置，不是数！  ?heap[left+1]:heap[left]是错的
                int maxSon = (left + 1 < heapSize && heap[left + 1] > heap[left]) ? left + 1 : left;
                if (heap[maxSon] <= heap[i]) {
                    break;
                }
                swap(heap, i, maxSon);
                //heapily(heap,maxSon);
                //note:index 和 maxSon位置都要移动 ,这一步不能忘
                i = maxSon;
                left = i * 2 + 1;
            }
        }

        public boolean isEmpty() {
            return heapSize == 0;
        }

        public boolean isFull() {
            return heapSize == limit;
        }


        public static void sort(int[] arr) {
            if (arr == null || arr.length < 2) {
                return;
            }
            //note  int index =0; X
            // O(N)
            for (int i = arr.length - 1; i >= 0; i--) {
                heapily(arr, i, arr.length);
            }
            int heapSize = arr.length;
            //swap(arr, 0, --heapSize);
            // O(N*logN)
            while (heapSize > 0) { // O(N)
                swap(arr, 0, --heapSize); // O(1)
                heapily(arr, 0, heapSize); // O(logN)
            }
        }
    }
}
