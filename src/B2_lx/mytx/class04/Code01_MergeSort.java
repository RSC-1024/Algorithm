package B2_lx.mytx.class04;

import java.util.Arrays;

/**
 * @title: Algorithm
 * @description: 递归
 * @author: 
 * @date: 2022/07/03 05:02
 */
public class Code01_MergeSort {
    public static void mergeSort(int[] arr){
        if (null ==arr || arr.length<2){
            return;
        }
        process(arr,0, arr.length-1);
    }
    public static void process(int[] arr,int L, int R){
        if (L == R){
            return;
        }
        int mid = L + ((R - L) >>1);
        process(arr,L,mid);
        process(arr,mid+1,R);
        merge(arr,L,R,mid);
    }
    public static void merge(int[] arr, int L, int R, int M){
        int[] help = new int[R-L+1];
        int i = 0;
        int p1 = L;
        int p2 = M + 1;
        while (p1 <=M && p2 <= R){
            if (arr[p1] <= arr[p2]){
                help[i] = arr[p1];
                i++;
                p1++;
            }else {
                help[i] = arr[p2];
                i++;
                p2++;
            }
            //help[i++] = arr[p1] >= arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= M){
            help[i] = arr[p1];
            i++;
            p1++;
        }
        while (p2 <= R){
            help[i] = arr[p2];
            i++;
            p2++;
        }
        for (int j = 0; j < help.length; j++) {
            arr[L + j] = help[j];
        }
        System.out.println(Arrays.toString(help));
    }
    public static void main(String[] args) {
        int[] arr = new int[]{8,3,5,2,7,4,9,1,6};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
