package B2_lx.mytx.class01;

import java.util.Arrays;

/**
 * @title: Algorithm
 * @description: 插入排序
 * @author: Lucy
 * @date: 2022/05/21 19:51
 */
public class Code03_InsertionSort {
    public static void insertionSort(int[] arr){
        for (int i =1; i< arr.length; i++){
            for (int j=i-1; j>=0 && arr[j]>arr[j+1]; j--){
                swap(arr,j, j+1);
            }
        }
    }
    public static void swap(int[] arr, int i, int j){
        //int temp = arr[i];
        //arr[i] = arr[j];
        //arr[j] = temp;
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    public static int[] generateRandomArray(int maxSize,int maxValue){
        System.out.println(Math.random());
        System.out.println(maxSize* Math.random());
        System.out.println((int)(maxSize* Math.random()));
        int[] arr = new int[(int)((maxSize) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(maxSize* Math.random());
        }
        return arr;
    }
    public static void main(String[] args) {
        int[] arr = {8,2,4,7,5,9,6,3};
        System.out.println(Arrays.toString(arr));
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
        int[] randomArr = generateRandomArray(8,9);
        System.out.println(Arrays.toString(randomArr));
    }
}
