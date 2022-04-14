package dachang.class01;

import java.io.File;
import java.util.Stack;

public class class02 {
    //  stack.push(root); 插入顶端，add 插入底端 .file.isDirectory 是文件夹  file.isFile 是文件
    // 注意这个函数也会统计隐藏文件
    public static int getFileNumber(String folderPath) {
        File root = new File(folderPath);
        int total = 0;
        //isDirectory 文件夹  isFile 文件
        if (!root.isDirectory() && !root.isFile()) {
            return 0;
        }
        // 是文件
        if (root.isFile()) {
            return 1;
        }
        Stack<File> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            File file = stack.pop();
            for (File next : file.listFiles()) {
                if (next.isFile()) {
                    total++;
                } else {
                    stack.add(next);
                }
            }
        }
        return total;
    }


    public static void main(String[] args) {
        // 你可以自己更改目录
        String path = "/Users/madanmei/Desktop/";
        System.out.println(getFileNumber(path));
    }
}
