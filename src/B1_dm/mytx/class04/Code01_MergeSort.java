package mytx.class04;

import java.util.Arrays;

public class Code01_MergeSort {
    public static void mergeSort1(int[] args) {
        if (args == null || args.length < 2) {
            return;
        }

        process(args, 0, args.length -1);
    }

    private static void process(int[] arr, int l, int r) {
        //边界
        if (l==r){
            return;
        }
        //merge fix:  m =l +(r-l)>>1 不对
        int m =l +((r-l)>>1);
        process(arr,l,m);
        process(arr,m+1,r);
        mergeSort(arr,l,m,r);
    }

    private static void mergeSort(int[] arr, int l, int m, int r) {
        int i=0;
        int p1=l;
        int p2=m+1;
        int[] help = new int[r-l+1];
        while (p1<=m && p2<=r){
            help[i++]=arr[p1]<arr[p2]?arr[p1++]:arr[p2++];
        }
        while (p1<=m ){
            help[i++]=arr[p1++];
        }
        while (p2<=r){
            help[i++]=arr[p2++];
        }
        for ( i = 0; i < help.length; i++) {
            arr[l+i]=help[i];
        }
    }
    // for test
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    // for test
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    // for test
    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    // for test
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    // for test
    public static void main(String[] args) {

        int maxSize = 100;
        int maxValue = 100;
        System.out.println("测试开始");

            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            mergeSort1(arr1);
            Arrays.sort(arr2);
            if (!isEqual(arr1, arr2)) {
                System.out.println("出错了！");
                printArray(arr1);
                printArray(arr2);
            }

        System.out.println("测试结束");
    }
}
