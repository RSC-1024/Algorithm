package mytx.class04;

public class Code01_MergeSortByStept {

    public static void mergeByStept(int[] arr) {
        int step =1;
        int n=arr.length;
        while (step<n){
            int l=0;
            while (l+step<n){
                int r=l+step;
                int m=l+((r-1)>>1);
                merge(arr,l,m,r);
                l=r+1;
            }
            //notice: 这里没想到 防止溢出
            if(step>n/2){
                break;
            }
            step=step<<1;
        }
    }

    public static void merge(int[] arr, int L, int M, int R) {
        int[] help = new int[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = M + 1;
        while (p1 <= M && p2 <= R) {
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        // 要么p1越界了，要么p2越界了
        while (p1 <= M) {
            help[i++] = arr[p1++];
        }
        while (p2 <= R) {
            help[i++] = arr[p2++];
        }
        for (i = 0; i < help.length; i++) {
            arr[L + i] = help[i];
        }
    }
}
