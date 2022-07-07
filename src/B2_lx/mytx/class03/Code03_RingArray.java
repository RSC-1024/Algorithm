package B2_lx.mytx.class03;

import java.util.Arrays;

/**
 * @title: Algorithm
 * @description: 用数组实现队列（循环数组）
 * @author: 
 * @date: 2022/07/01 22:40
 */
public class Code03_RingArray {
    private static class MQueue{
        private int[] arr;
        private int begin;  // 取的时候看它
        private int end;    // 放的时候看它
        private int size;
        private int limit;  // 数组的容量长度

        public MQueue(int limit) {
            arr = new int[limit];
            this.begin = 0;
            this.end =0;
            this.size = 0;
            this.limit = limit;
        }
        public void put(int a){
            if (size >= limit){
                throw new RuntimeException("队列已满，禁止put操作");
            }
            size++;
            arr[end] = a;
            end =  nextIndex(end);
        }
        public int pop(){
            if (size==0){
                throw new RuntimeException("队列已空，没的弹了");
            }
            size--;
            int result = arr[begin];
            begin = nextIndex(begin);
            return result;
        }
        
        public int nextIndex(int i){
            if (i >= limit){
                i = 0;
            }else {
                i++;
            }
            return i;
        }
    }

    public static void main(String[] args) {
        MQueue queue = new MQueue(5);
        queue.put(1);
        queue.put(2);
        queue.put(3);
        queue.put(4);
        queue.pop();
        queue.put(5);
        //queue.put(6);
        System.out.println(Arrays.toString(queue.arr));
    }
}
