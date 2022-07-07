package B2_lx.mytx.class03;

import java.util.Stack;

/**
 * @title: Algorithm
 * @description: 用栈实现队列
 * @author: 
 * @date: 2022/07/03 17:08
 */
public class Code06_TwoStacksImplementQueue {
    public static class TwoStacksQueue {
        public Stack<Integer> stackPush;
        public Stack<Integer> stackPop;
        
        // 向备用栈pop里导数据
        private void pushToPop(){
            if (stackPop.isEmpty()){
                while (!stackPush.isEmpty()){
                    stackPop.push(stackPush.pop());
                }
            }
        }
        private void push(Integer a){
            stackPush.push(a);
        }
        private void pop(){
            
        }
    }
}