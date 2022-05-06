package mytx.class04;

/**
 * Description:
 *
 * @author madanmei
 * @version 1.0.0
 */

public class Code04_BiggerThanRightTwice {
    public static int bigerThanRightTwice(int[] arr) {
        //notice: 边界条件判定
        if (arr==null || arr.length<2){
            return 0;
        }
        return process(arr, 0, arr.length - 1);
    }

    private static int process(int[] arr, int l, int r) {
        if (l == r) {
            return 0;
        }
        int m = l + ((r - l) >> 1);


        return process(arr, l, m)
                +
                process(arr, m + 1, r)
                +
                merge(arr, l, m, r);

    }

    private static int merge(int[] arr, int l, int m, int r) {
        int windows=m+1;
        int ans=0;
        for (int i = 0; i <= m; i++) {
            while (windows<r && arr[i]<2*arr[windows]){
                windows++;
            }
            //notice:windows -m -1  需要减1
            ans=windows-m-1;
        }

        int p1 = l;
        int p2 = m + 1;
        int p3 = 0;
        int[] help = new int[r - l + 1];

        while (p1 <= m && p2 <= r) {
            help[p3++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1<=m){
            help[p3++]=arr[p1++];
        }
        while (p2<=r){
            help[p3++]=arr[p2++];
        }
        for (int i = 0; i < help.length; i++) {
            arr[l + i] = help[i++];
        }
        return ans;
    }
} 
