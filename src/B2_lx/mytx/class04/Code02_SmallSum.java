package B2_lx.mytx.class04;

/**
 * @title: Algorithm
 * @description: 小和问题
 * @author: 北京小桔汇金网络科技有限公司
 * @date: 2022/07/06 23:23
 */
public class Code02_SmallSum {
    
    public static Integer process(Integer[] arr,int L,int R){
        if (L == R){
            return 0;
        }
        int mid = L + ((R - L)>>1);
        return process(arr,L,mid) + 
                process(arr,mid +1, R) +
                merge(arr,L,R,mid);
    }
    public static Integer merge(Integer[] arr,int L,int R,int mid){
        Integer[] help = new Integer[R-L+1];
        int i = 0;
        int p1 = L;
        int p2 = mid +1;
        int result = 0;
        while (p1 <= mid && p2 <=R){
            result += arr[p1] < arr[p2] ? arr[p1] * (R-p2+1) :0;
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
            //if (arr[p1] <= arr[p2]){
            //    help[i] = arr[p1];
            //    i++;
            //    p1++;
            //}else {
            //    help[i] = arr[p2];
            //    i++;
            //    p2++;
            //}
        }
        while (p1 <=mid){
            help[i++] = arr[p1++];
        }
        while ((p2 <=R)){
            help[i++] = arr[p2++];
        }
        for (i = 0; i < help.length; i++) {
            arr[L+i] = help[i];
        }
        return result;
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1,3,4,2,5};
        System.out.println(process(arr,0,4));;
    }
}
