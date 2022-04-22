package tixi.class04;

/**
 * Description:
 *
 * @author madanmei
 * @version 1.0.0
 */
//用merge方式对数组进行排序
public class Code01_MergeSort {
    public static void merge(int[] arr){
        if (arr.length<2){
            return;
        }

        process(arr,0,arr.length-1);


    }


    private static void process(int[] arr, int l, int r) {
        if(l==r){
            return;
        }
        int m =l+r<<2;
        process(arr,l,m);
        process(arr,m+1,r);
        merge(arr,l,m,r);
    }

    private static void merge(int[] arr, int l, int m, int r) {

    }


} 
