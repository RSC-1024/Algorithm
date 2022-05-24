package B2_lx.dachang.class01;

/**
 * @title: Algorithm
 * @description: 绳子覆盖点数最多问题
 * @author: 
 * @date: 2022/04/13 23:00
 */
public class Code01 {
    /** 问题：
     * 给定一个有序数组arr，代表坐落在X轴上的点，给定一个正数K，代表绳子的长度，返回绳子最多压中几个点？即使绳子边缘处盖住点也算盖住
     * 思路1：
     * 绳子长K，假如固定绳子右端的点R，然后计算 R-K = m。
     * 只需找出第1个>=m的数就是绳子左侧覆盖的点nearestLef 。那么 R-L+1=覆盖住的点数 
     * 算法复杂度 O(N * LogN) */
    public static Integer maxPoint1(int[] arr,int k){
        int result =1;
        for (int i = 0; i < arr.length; i++) {
            int m = arr[i] - k;
            int nearestLeft = getNearestLeft(arr,i,m);
            result = Math.max(result, i-nearestLeft+1);
        }
        return result;
    }
    // 算术符合运算符 优先级 > 位运算符
    // 计算中间点 mid ，右移除2
    public static Integer getNearestLeft(int[] arr,int r, int value){
        int l = 0;
        int nearestLeft =r;
        while (l <= r){
            int mid = l + ((r-l) >> 1) ;
            if (arr[mid] >= value){
                nearestLeft = mid;
                r = mid -1;
            }else {
                l = mid +1;
            }
        }
        return nearestLeft;
    }

    /**
     * 思路2：滑动窗口。
     * 定义l、r两个指针，当l固定的时候，r依次向右走，直到，那就是当前能覆盖住的点数。
     * 
     */
    public static Integer maxPoint2(int[] arr, int k){
        int l = 0;
        int r = 0;
        int result =1;
        for (int i = 0; i < arr.length; i++) {
            l = i;
            int betweenlr= r-l;
            while (r<=arr.length-1 && arr[r]-arr[l] <= k){
                betweenlr = r-l+1;
                r++;
            }
            result = Math.max(result,betweenlr);
        }
        return result;
    }
    
    public static void main(String[] args) {
        int[] arr = {1,3,4,7,13,16,17};
        int k = 4;
        Integer result = maxPoint1(arr, k);
        System.out.println(result);

        int[] arr1 = {1,4,5,6,8,10,12,17};
        int k1 = 4;
        Integer result1 = maxPoint2(arr1, k1);
        System.out.println(result1);
    }
    
}