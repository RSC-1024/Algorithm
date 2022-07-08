package B2_lx.mytx.class04;

/**
 * @title: Algorithm
 * @description: 在一个数组中，对于每个数num，求有多少个后面的数 * 2 依然<num，求总个数
 * @author: 北京小桔汇金网络科技有限公司
 * @date: 2022/07/08 09:55
 */
public class Code04_BiggerThanRightTwice {
    public static Integer biggerThanRightTwice(int[] arr){
        if (null == arr || arr.length<2){
            return 0;
        }
        return process(arr,0,arr.length-1);
    }
    public static int process(int[] arr,int l, int r){
        if (l == r ){
            return 0;
        }
        int m = l + ((r-l)>>1);
        return process(arr,l,m) + process(arr,m+1,r) + merge(arr,l,r,m);
    }
    public static int merge(int[] arr,int l,int r,int m){
        //分成2步，先merge计算出 右边有几个数，乘2后仍然小于 它。
        int winR = m+1;
        int result = 0;
        for (int i = l; i<=m; i++){
            while (winR <=r && arr[i] > (arr[winR] * 2)){
                winR ++;
            }
            result += winR - (m +1);
        }
        // 这里无需merge排序，不需要归并算法的排序操作
        /*int[] help = new int[r-l+1];
        int i = 0;
        int p1 = l;
        int p2 = m+1;
        while (p1 <= m && p2 <= r){
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++] ;
        }
        while (p1 <=m){
            help[i++] = arr[p1++];
        }
        while (p2 <= r){
            help[i++] = arr[p2++];
        }
        
        for (int j = 0; j< help.length; j++){
            arr[l+j] = help[j];
        }*/
        return result;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{3,1,7,0,2};
        System.out.println(biggerThanRightTwice(arr));
    }
}
