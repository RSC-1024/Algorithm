package mytx.class05;

/**
 * @author madanmei
 * @description  2
 * @date 2022/5/1 22:44
 **/
public class PartitionAndQuickSort {

    public static void quickSort2(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process(arr, 0, arr.length - 1);

    }

    public static void process(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }

        int equalArea[] = range(arr, l, r);
        process(arr, l, equalArea[0] - 1);
        process(arr, equalArea[1] + 1, r);
    }

    private static int[] range(int[] arr, int l, int r) {
        if (l > r) {
            return new int[]{-1, -1};
        }
        if (l == r) {
            return new int[]{l, r};
        }

        //小于区域的最右侧
        int less = l - 1;
        //大于区域的最左侧
        int more = r;

        int i = l;
        //fix index <  more 不是less<more)
        while (i < more) {
            if (arr[i] < arr[r]) {
                swap(arr, ++less, i++);
            }
            //fix :else if 注意这里 没有i++;
            else if (arr[i] > arr[r]) {
                swap(arr, --more, i);
            }
            if (arr[i] == arr[r]) {
                i++;
            }
            //错的，右边的数还没比较 不能移动
            // i++;
        }
        swap(arr, --more, r);
        //fix less +1
        return new int[]{less, more};
    }

    public static void swap(int[] arr, int x, int y) {
        int tmp = arr[x];
        arr[x] = arr[y];
        arr[y] = tmp;
    }
}
