package tixi.class05;

/**
 * Description:
 *
 * @author madanmei
 * @version 1.0.0
 */

public class CountOfRangeSum {

    public static  int  count(int[] arr,int lower ,int up) {
        if(arr==null || arr.length<1){
            return 0;
        }
        int [] sums =new int[arr.length];
         sums[0]=arr[0];
        for (int i = 1; i < arr.length; i++) {
            sums[i]=sums[i-1]+arr[i];
        }
        return process(sums,0,arr.length-1,lower,up);
    }

    //
    public static int process(int[] sum,int L,int R,int lower,int up ){
        if (L==R){
            return (sum[L]>=lower && sum[R]<=up)?1:0;
        }
        int M=L+(R-L)>>1;

        return  process(sum,L,M,)

    }
} 
