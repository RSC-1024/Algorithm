package B2_lx.mytx.class01;

import java.util.Arrays;

/**
 * @title: Algorithm
 * @description: 选择排序
 * @author: Lucy
 * @date: 2022/05/18 15:47
 */
public class Code01_selectionSort {
    public static void selectionSort(int[] arr){
        if (null == arr || arr.length < 2){
            return;
        }
        for (int i = 0; i < arr.length-1; i++) {
            int min = i;
            for (int j = i+1; j< arr.length; j++){
                min = arr[j] < arr[min] ? j : min;
            }
            if (arr[i] > arr[min]){
                swap(arr,i,min);
            }
        }
        System.out.println(Arrays.toString(arr));
    }
    public static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void comparator(int[] arr){
        Arrays.sort(arr);
    }
    public static void main(String[] args) {
        int[] arr = {8,6,1,3,7,5,2};
        System.out.println(Arrays.toString(arr));
        //selectionSort(arr);
        comparator(arr);
        System.out.println(Arrays.toString(arr));

    }
}
