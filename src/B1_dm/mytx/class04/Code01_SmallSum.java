package mytx.class04;

/**
 * Description:
 *
 * @author madanmei
 * @version 1.0.0
 */

public class Code01_SmallSum {
    public static int getSmallSum(int[] arr) {
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

        //notice: sum 不用传入进去。递归想最外一层，sum 等于左右两个子集计算好的结果，再加上左右子集merge过程出现的数据即可
        return process(arr, l, m)
                +
                process(arr, m + 1, r)
                +
                merge(arr, l, m, r);

    }

    private static int merge(int[] arr, int l, int m, int r) {
        int p1 = l;
        int p2 = m + 1;
        int sum = 0;
        int p3 = 0;
        int[] help = new int[r - l + 1];
        while (p1 <= m && p2 <= r) {
            sum = arr[p1] < arr[p2] ? arr[p1] * (r - m + 1) : 0;
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
        return sum;
    }
} 
