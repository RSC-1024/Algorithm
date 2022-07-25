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
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr,i);
        }
    }
    public static void heapInsert(int[] arr,int index){
        while (arr[index] > arr[(index-1)/2]){
            swap(arr,index,(index-1)/2);
            index = (index-1)/2;
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
