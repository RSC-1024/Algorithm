package b1.dm.dachang.class01;

public class class01 {
    public static void main(String[] args) {
        int right =2;
        int left =0;
        System.out.println(right - (left++));
        System.out.println(left);
    }

    public static int  maxNum(int[] arr, int l){
       int left = 0;
       int right =0;
       int length =arr.length;
       int max =0;
       while (left<length){
           while (right<length && arr[right]-arr[left]<=l){
               right++;
           }
           max = Math.max(max,right-left);
           left++;

       }
       return  max;
    }
}
