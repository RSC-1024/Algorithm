package dachang.class01;

import java.util.HashMap;
import java.util.Map;

//数组中添加加减运算符得到指定值的所有方法
public class class07 {

    public static int process(int[] arr, int index, int target, Map<Integer, Map<Integer, Integer>> map) {
        if (index == arr.length - 1) {
            return target == 0 ? 1 : 0;
        }
        if (map.get(index) != null && map.get(index).get(target) != null) {
            return map.get(index).get(target);
        }
        int ans = process(arr, index + 1, target - arr[index], map) + process(arr, index + 1, target + arr[index], map);
        if (!map.containsKey(index)) {
            map.put(index, new HashMap<>());
        }
        map.get(index).put(target, ans);
        return ans;
    }




 /*
494.数组中添加加减运算符得到指定值的所有方法
#大厂刷题班01 #DP #动态规划 #Medium  #LeetCode #腾讯
   给定一个数组arr，你可以在每个数字之前决定+或者-, 但是必须所有数字都参与, 再给定一个数target，请问最后算出target的方法数是多少？*/
}
