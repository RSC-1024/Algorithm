package mytx.class03;

/**
 * 用递归方法取最大值
 */
public class class08_GetMax {
    int getMax(int[] arr){
      return process(arr,0,arr.length-1);
    }

    //返回 start-end区间的最大值/
    //  arr[L..R]范围上求最大值  L ... R   N
    int process(int[] arr, int start, int end){
        //退出条件
        if (end==start){
            return arr[start];
        }
        int mid= start+(end-start)>>1;
        int leftMax= process(arr,start,mid);
        //fix:注意入参
        int rightMax=process(arr,mid+1,end);
        return Math.max(leftMax,rightMax);
    }
}
