package B2_lx.mytx.class02;

/**
 * @title: Algorithm
 * @description: 奇数次偶数次
 * @author: Lucy
 * @date: 2022/05/23 15:53
 */
public class Code02_EvenTimesOddTimes {
    /**
     * 一个数组中有一种数出现了奇数次，其他数都出现了偶数次，怎么找到并打印这种数 
     */
    public static void printOddTimesNum1(int[] arr){
        int eor = 0;
        for (int i = 0; i < arr.length; i++) {
            eor ^= arr[i];
        }
        System.out.println(eor);
    }

    /**
     * 一个数组中有两种数出现了奇数次，其他数都出现了偶数次，怎么找到并打印这两种数 
     * @param arr
     * 思路：eor = a ^ b
     * 找到 eor 最右侧的 1，说明 该位置上 a 和 b 一定不一样（一个是0，一个是1）
     * 把数组arr中所有数，按该位置是0或1分两类，这时候 a和b 肯定各在一个分类组里
     * 定义 eor1 = 分类组1的数据异或，所以 eor1 = a
     * 所以 吧= eor ^ eor1
     */
    public static void printOddTimesNum2(int[] arr){
        int eor = 0;
        for (int i = 0; i < arr.length; i++) {
            eor ^= arr[i];
        }
        int rightOne = eor & (-eor);
        int eor1 = 0;
        for (int i = 0; i < arr.length; i++) {
            if ((arr[i] & rightOne) !=0){
                eor1 ^= arr[i];
            }
        }
        System.out.println("一个"+eor1);
        System.out.println("另一个"+(eor ^ eor1));
    }

    public static void main(String[] args) {
        int[] arr = {3,8,2,4,3,9,4,2,9};
        printOddTimesNum1(arr);
        int[] arr1 = {3,8,2,4,3,9,4,2,9,2};
        printOddTimesNum2(arr1);

    }
}
