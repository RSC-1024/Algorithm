package mytx.class05;


/**
 * @author madanmei
 * @description todo
 * @date 2022/5/1 5:21 下午
 **/
public class QuickSortRecursiveAndUnrecursive {

    public static void sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process(arr, 0, arr.length - 1);
    }

    private static void process(int[] arr, int L, int R) {
        if (L >= R) {
            return ;
        }
        swap(arr, (int) (L + Math.random() * (R - L)), R);
        //左 小于区域的最边上的位置
        //右 大于区域的最边上的位置
        int[] areaIndex = range(arr, L, R);
        process(arr, L, areaIndex[0]);
        process(arr, areaIndex[1] + 1, R);
    }

    //返回相等区域的左右边界 并划分界限
    private static int[] range(int[] arr, int l, int r) {
        if (l > r) {
            return new int[]{-1, -1};
        }
        if (l == r) {
            return new int[]{l, r};
        }
        int less = l - 1;
        int more = r;
        int i =l;

        //fix 不能和右边界碰到 不用到R
        while (i<more ){
            if(arr[i]==arr[r]){
                i++;
            }else if(arr[i]<arr[r] ){
                swap(arr,i++,++less);
            }else {
                swap(arr,i,--more);
            }
        }
        //之后一步需要进行换
        swap(arr,r,more);
        return new int[]{less+1,more};
    }

    private static void swap(int[] arr, int x, int y) {
        int tmp = arr[x];
        arr[x] = y;
        arr[y] = tmp;
    }
}
