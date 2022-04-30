package tixi.class05;

/**
 * Description:
 *
 * @author madanmei
 * @version 1.0.0
 */

public class CountOfRangeSum {

    public static int count(long[] arr, int lower, int up) {
        if (arr == null || arr.length < 1) {
            return 0;
        }
        long[] sums = new long[arr.length];
        sums[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            sums[i] = sums[i - 1] + arr[i];
        }
        return process(sums, 0, arr.length - 1, lower, up);
    }

    //
    public static int process(long[] sum, int L, int R, int lower, int up) {
        if (L == R) {
            return (sum[L] >= lower && sum[R] <= up) ? 1 : 0;
        }
        int M = L + (R - L) >> 1;
        return process(sum, L, M, lower, up) + process(sum, M + 1, R, lower, up) + merge(sum, L, M, R, lower, up);
    }

    //fix long
    private static int merge(long[] arr, int L, int M, int R, int lower, int up) {
        int ans = 0;
        int windowsL = L;
        int windowsR = R;
        //[)
        for (int i = M + 1; i <= R; i++) {
            long min = arr[i] - up;
            long max = arr[i] - lower;

            while (windowsL<=M && arr[windowsL] < min) {
                windowsL++;
            }
            while (windowsR<=M &&  arr[windowsR] <= max) {
                windowsR++;
            }
            ans += R - L;
        }
        long[] help = new long[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = M + 1;
        while (p1 <= M && p2 <= R) {
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= M) {
            help[i++] = arr[p1++];
        }
        while (p2 <= R) {
            help[i++] = arr[p2++];
        }
        for (i = 0; i < help.length; i++) {
            arr[L + i] = help[i];
        }
        return ans;
    }
} 
