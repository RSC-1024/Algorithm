package mytx.classo8;

import java.util.Arrays;

//非负数
public class Code_RadixSort {
    //位数
    //
    public static void radixSort(int[] arr) {
        //max
        int max =0;
        for (int i = 0; i < arr.length; i++) {
            max= Math.max(max,arr[i]);
        }
        //几位数 个位数是则返回1 1位数
        int count = getMaxRadix(max);

        int[] help =new int[arr.length];
        for (int j = 1; j <= count; j++) {
            //note: 把bucket 放在了for 外边，导致每次都用了上一轮的脏数据 注意容器变量的使用范围 和是否需要初始化
            int[] bucket=new int[10];
            for (int i = 0; i < arr.length; i++) {
                //个位数排序
                //获取当前位数是什么数
                bucket[getDigit(arr[i],j)]++;
            }
            //先计数
            for (int i = 1; i < 10; i++) {
                bucket[i]=bucket[i]+bucket[i-1];
            }
            printArray(bucket);


            // note：部分有序了已经 从后往前不会反转
            //1： 201 231  82 29
            //2： 201 29  231 82  （201 和231 已经有序了 所以顺序不能乱。如果知道百位数为2的结束位置，一定是最右边的最大）
            //3： 82
            //3：     82      231  （百位数排序：bucket[2]=4，即 231在第4-1位；bucket[0]=2 即84在第2-1=1位）
            //3： 29  82      231  （百位数排序：bucket[2]=4，即 231在第4-1位，放入之后bucket[2]减一；bucket[0]=2 即84在第2-1=1位）
            //3： 29  82  201 231

            for (int i = arr.length-1; i >=0; i--) {
                System.out.println("arr== ");
                printArray(arr);
                System.out.println("arr[i]== "+ arr[i]+ "第"+j+"位=="+ getDigit(arr[i],j));
               // 60689
                //note:需要减一 例如 503  j=2；getDigit(arr[i],j) ：例如5 第j位是0; x=1 排1位
                int x=bucket[getDigit(arr[i],j)];
                System.out.println("help== x="+x+"i="+i);
                printArray(help);

                help[x-1]=arr[i];
                //note
                bucket[getDigit(arr[i],j)]--;

            }

            //note: arr  变位置
            for (int i = 0; i < arr.length; i++) {
                arr[i]=help[i];
            }

        }
    }

    //取第几位 345 ，2 返回4
    private static int getDigit(int x, int d) {
        //note: 缩到个位，然后取余数
        //  (int) x/Math.pow(10,d-1)%10);
        return  x/(int)Math.pow(10,d-1)%10;
    }

    //个位数是则返回1 1位数
    private static int getMaxRadix(int max) {
       int ans =1;
       int tmp =max;
       while (tmp/10>0){
           ans++;
           tmp=tmp/10;
       }
        return ans;
    }


    // for test
    public static void comparator(int[] arr) {
        Arrays.sort(arr);
    }

    // for test
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random());
        }
        return arr;
    }

    // for test
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    // for test
    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    // for test
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // for test
    public static void main(String[] args) {
        int testTime = 1;
        int maxSize = 100;
        int maxValue = 100000;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            radixSort(arr1);
            comparator(arr2);
            if (!isEqual(arr1, arr2)) {
                succeed = false;
                printArray(arr1);
                printArray(arr2);
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");

        int[] arr = generateRandomArray(maxSize, maxValue);
        printArray(arr);
        radixSort(arr);
        printArray(arr);

    }
}
