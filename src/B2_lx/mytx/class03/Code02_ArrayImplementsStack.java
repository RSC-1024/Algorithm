package B2_lx.mytx.class03;

/**
 * @title: Algorithm
 * @description: 用数组来实现栈(数组+index）
 * @author: 
 * @date: 2022/07/01 21:49
 */
public class Code02_ArrayImplementsStack {
    private String[] arr=new String[5];
    private int index=0;
    
    public void put(String a){
        if (index>arr.length){
            System.out.println("超过数组长度");
            return;
        }
        arr[index] = a;
        index++;
    }
    public String take(){
        if(index <=0){
            System.out.println("已经空了，没得取");
            return "";
        }
        index--;
        return arr[index];
    }

    public static void main(String[] args) {
        Code02_ArrayImplementsStack c = new Code02_ArrayImplementsStack();
        c.put("0");
        c.put("1");
        System.out.println(c.index);
        c.take();
        System.out.println(c.index);
    }
}
