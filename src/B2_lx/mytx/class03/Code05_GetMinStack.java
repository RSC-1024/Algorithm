package B2_lx.mytx.class03;

import java.util.Stack;

/**
 * @title: Algorithm
 * @description: 获取栈最小元素
 * @author: 
 * @date: 2022/07/03 16:17
 */
public class Code05_GetMinStack {
    private static class MyStack{
        private Stack<Integer> stackData;
        private Stack<Integer> stackMin;

        public MyStack() {
            this.stackData = new Stack<>();
            this.stackMin = new Stack<>();
        }
        private void push(Integer a){
            if (this.stackMin.isEmpty()){
                this.stackMin.push(a);
            }else {
                this.stackMin.push(a< this.stackMin.peek() ? a: this.stackMin.peek());
            }
            this.stackData.push(a);
        }
        private int pop(){
            if (this.stackData.isEmpty()){
                throw new RuntimeException("stackData isEmpty!");
            }
            Integer value = this.stackData.pop();
            this.stackMin.pop();
            return value;
        }
    }
    

    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(3);
        stack.push(2);
        stack.push(4);
        System.out.println(stack.stackMin.peek());
        stack.push(1);
        System.out.println(stack.stackMin.peek());
        System.out.println(stack.stackData);
        System.out.println(stack.stackMin);
        stack.pop();
        System.out.println(stack.stackMin.peek());
        stack.pop();
        System.out.println(stack.stackMin.peek());

    }
}
