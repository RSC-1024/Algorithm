package B2_lx.mytx.class01;

import java.util.Arrays;

/**
 * @title: Algorithm
 * @description: 冒泡排序 
 * 第1次遍历，找出第1大的数，放到N-1位置上。
 * 第2次遍历，找出第2大的数，放到N-2位置上。
 * 第N-1次遍历，找出第N-1大的数，放到 1位置上。
 * @author: Lucy
 * @date: 2022/05/21 19:41
 */
public class Code02_bubbleSort {
    public static void bubbleSort(int[] arr){
        if (arr == null || arr.length <2){
            return;
        }
        for (int i = arr.length-1; i>0; i--){
            for (int j =0; j<i; j++){
                if (arr[j] > arr[j+1] ){
                    swap(arr,j,j+1);
                }
            }
        }
    }
    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {8,2,4,7,5,9,6,3};
        System.out.println(Arrays.toString(arr));
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
