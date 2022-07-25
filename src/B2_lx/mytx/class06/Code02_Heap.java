package B2_lx.mytx.class06;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @title: Algorithm
 * @description: 堆结构
 * @author: 北京小桔汇金网络科技有限公司
 * @date: 2022/07/23 15:33
 */
public class Code02_Heap {
    
    // 自定义实现 最大堆
    public static class myMaxHeap{
        private int[] heap;
        private final int limit;
        private int heapSize;

        public myMaxHeap(int limit) {
            heap = new int[limit];
            this.limit = limit;
            heapSize = 0;
        }

        // 在堆中插入元素
        private void push(int value){
            if (heapSize == limit){
                throw new RuntimeException("heap is full");
            }
            heap[heapSize] = value;
            //调整堆
            heapInsert(heap,heapSize++);
        }
        // 取出堆最大值，重新生成堆
        private int pop(){
            int result = heap[0];
            // 必须先--再赋值。因为 insert完后立刻hepaSize++了，最后的heapSize是空的
            swap(heap,0,--heapSize);
            heapify(heap,0,heapSize);
            return result;
        }
        // 每次插入 保证每个子树的最大值在顶部
        private void heapInsert(int[] arr, int index){
            while (arr[index] > arr[(index-1)/2]){
                swap(arr,index,(index-1)/2);
                index = (index-1)/2;
            }
        }
        private void heapify(int[] arr, int index,int heapSize){
            System.out.println("heapSize:"+heapSize);
            int left = index * 2 +1;
            while (left < heapSize){
                // 较大孩子的下标
                //int largest = arr[left] > arr[left+1] ? left : left+1;
                int largest = left+1 < heapSize && arr[left+1] > arr[left] ? left+1 : left;
                largest = arr[largest] > arr[index] ? largest : index;
                if (largest == index){
                    break;
                }
                swap(heap,largest,index);
                index = largest;
                left = index *2 +1;
            }
        }
        private void swap(int[] arr, int i, int j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    public static void main(String[] args) {
        // 优先级队列 实现堆-默认是最小堆
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.add(5);
        minHeap.add(2);
        minHeap.add(9);
        minHeap.add(6);
        minHeap.add(1);
        minHeap.add(3);
        System.out.println(Arrays.toString(minHeap.toArray()));
        
        // 优先级队列 实现 最大堆
        // compare比较两个数大小(a,b) <0优先返回第1个数；>0优先返回第2个数
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b-a);
        maxHeap.add(5);
        maxHeap.add(2);
        maxHeap.add(9);
        maxHeap.add(6);
        maxHeap.add(1);
        maxHeap.add(3);
        System.out.println(Arrays.toString(maxHeap.toArray()));

        System.out.println("##############################");
        
        // 自定义实现堆结构：最大堆
        myMaxHeap myMaxHeap = new myMaxHeap(6);
        myMaxHeap.push(5);
        myMaxHeap.push(2);
        myMaxHeap.push(9);
        myMaxHeap.push(6);
        myMaxHeap.push(1);
        myMaxHeap.push(3);
        System.out.println(Arrays.toString(myMaxHeap.heap));
        for (int i =0; i<2; i++){
            System.out.println(myMaxHeap.pop());;
        }
    }
}
