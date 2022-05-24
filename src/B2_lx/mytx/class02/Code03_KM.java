package B2_lx.mytx.class02;

/**
 * @title: Algorithm
 * @description: 在一个数组中，只有一种数出现了K次，其他数都出现了M次，问出现K次的数是几？
 * @author: Lucy
 * @date: 2022/05/24 09:26
 */
public class Code03_KM {
    public static int kmTest(int[] arr, int k, int m){
        // 定义32位的数组t；
        // 遍历arr数组的数，每个数二进制表示，各个位置上有1，则累加到数组t位置上
        // 如果t数组该位置上的sum % m !=0,整除m不为0，说明出现K次的数，在这个位置有1
        // 这样找出 t数组上 整除后，!=0的位。
        int[] t = new int[32];
        for (int num : arr) {
            for (int i = 0; i < 32; i++) {
                /*if (((num << 1) & 1 ) !=0){
                    t[i] += 1;
                }*/
                t[i] += (num >>i) & 1;
            }
        }

        int ans =0;
        for (int i = 0; i < 32; i++) {
            if (t[i] % m !=0){
                ans |= (1 << i);
            }
        }
        return ans;        
    }

    public static void main(String[] args) {
        int[] arr = {2,4,5,4,5,4,2,5};
        System.out.println(kmTest(arr,2,3));
    }
}
