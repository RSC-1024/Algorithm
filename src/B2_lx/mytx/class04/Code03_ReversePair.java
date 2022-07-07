package B2_lx.mytx.class04;

/**
 * @title: Algorithm
 * @description: 逆序对
 * @author: 北京小桔汇金网络科技有限公司
 * @date: 2022/07/07 15:44
 */
public class Code03_ReversePair {
    public static int reversePair(int[] arr){
        if (null == arr || arr.length <2){
            return 0;
        }      
        return process(arr,0,arr.length -1);
    }
    public static int process(int[] arr, int L, int R){
        if (L == R){
            return 0;
        }
        int mid = L + ((R - L)>>1);
        
        return process(arr,L,mid) + process(arr,mid+1, R) + merge(arr,L,mid,R);
    }
    public static int merge(int[] arr,int L, int mid, int R){
        int[] help = new int[R -L +1];
        int i = help.length -1;
        int p1 = mid;
        int p2 = R;
        int result = 0;
        while (p1 >=L && p2 > mid){
            /*if (arr[p1] <= arr[p2]){
                help[i] = arr[p2];
                i--;
                p2 --;
            } else {
                help[i] = arr[p1];
                i--;
                p1 --;
                result = result + (p2 - mid);
            }*/
            result += arr[p1] > arr[p2] ? (p2 - mid) : 0;
            help[i--] = arr[p1] > arr[p2] ? arr[p1--] : arr[p2--];
        }
        while (p1>=L){
            help[i--] = arr[p1--];
        }
        while (p2 >mid){
            help[i--] = arr[p2--];
        }
        for ( i = 0; i < help.length; i++) {
            arr[L+i] = help[i];
        }
        return result;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{3,5,1,2,6,4,9,7};
        System.out.println(reversePair(arr));
    }
}
