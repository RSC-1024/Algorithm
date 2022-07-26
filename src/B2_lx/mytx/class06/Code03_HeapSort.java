package B2_lx.mytx.class06;

import java.util.Arrays;

/**
 * @title: Algorithm
 * @description: 堆排序
 * @author: 北京小桔汇金网络科技有限公司
 * @date: 2022/07/23 19:39
 */
public class Code03_HeapSort {

    public static void heapSort(int[] arr){
        if (null == arr || arr.length <2){
            return;
        }
        // 自上而下的初始化 大根堆
        // O(N*logN) ：先for循环一遍N,然后 logN调整
        //for (int i = 0; i < arr.length; i++) {
        //    heapInsert(arr,i);
        //}
        
        // 另外一种方法：自下而上的 初始化大根堆
        // O(N)：倒序 依次是大根堆。
        for (int i = arr.length - 1; i >= 0; i--) {
            heapify(arr,i,arr.length);
        }
        int heapSize = arr.length;
        swap(arr,0,--heapSize);
        while (heapSize>0){
            heapify(arr,0,heapSize);
            swap(arr,0,--heapSize);
        }
    }
    public static void heapInsert(int[] arr,int index){
        // 如果当前节点 > 父亲节点
        // 交换 
        // 变更当前节点=父亲节点
        while (arr[index] > arr[(index-1)/2]){
            swap(arr,index,(index-1)/2);
            index = (index-1)/2;
        }
    }
    public static void heapify(int[] arr,int index,int heapSize){
        // 有左孩子
        int left = index*2+1;
        while (left < heapSize){
            // 找出index的孩子 中最大的一个
            int largest = left+1 < heapSize && arr[left+1]>arr[left] ? left+1 :left;
            
            if (arr[index] < arr[largest]){
                swap(arr,index,largest);
                left = largest*2+1;
            }else {
                break;
            }
        }
    }
    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{5,2,9,6,1,3};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
