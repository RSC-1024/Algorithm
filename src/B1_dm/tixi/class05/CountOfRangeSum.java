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

        return  process(sum,L,M,lower,up)+process(sum,M+1,R,lower,up)+merge(sum,L,M,R,lower,up);

    }

    //long
    private static int merge(long[] sum, int L, int M, int R, int lower, int up) {
        //
        int windowL=L;
        int windowR=L;
        int ans=0;
        for (int i=M+1; i <= R; i++) {
            int min= sum[i]-up;
            int max =sum[i]-lower;
            while (sum[windowL]<min){
                windowL++;
            }
            while (sum[windowR]<max){
                windowR++;
            }
            ans+=windowR-windowL;
            long[] help = new long[R - L + 1];
            int p = 0;
            int p1 = L;
            int p2 = M + 1;
            while (p1 <= M && p2 <= R) {
                help[p++] = sum[p1] <= sum[p2] ? sum[p1++] : sum[p2++];
            }
            while (p1 <= M) {
                help[p++] = sum[p1++];
            }
            while (p2 <= R) {
                help[p++] = sum[p2++];
            }
            for (p = 0; p < help.length; p++) {
                sum[L + p] = help[p];
            }
        }
        //统计
        //merge
    }

} 
