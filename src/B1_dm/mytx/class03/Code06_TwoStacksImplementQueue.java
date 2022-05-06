package mytx.class03;

import java.util.Stack;

public class Code06_TwoStacksImplementQueue {
    public static class TwoStacksQueue<T>{
        Stack<T>  s1;
        Stack<T>  s2;
        public TwoStacksQueue(T t){
            this.s1 = new Stack<T>();
            this.s2 = new Stack<T>();
        }

        public T pop(){
            if (s2.isEmpty() && s1.empty()){
                throw new RuntimeException("empty ,can not pop");
            }
            pushToPop();
            return s2.pop();
        }
        public void push(T t){
            s1.push(t);
        }

        public T peek(){
            if (s2.isEmpty() && s1.empty()){
                throw new RuntimeException("empty ,can not peek");
            }
            pushToPop();
            return s2.peek();
        }
        //控制好条件，只要s2里有数据，就还不能倒数据；
        //fix：思路都写对了，但是没有提取公共代码
        public void pushToPop(){
            if (!s2.isEmpty()){
                return;
            }
            while (!s1.isEmpty()){
                s2.push(s1.pop());
            }
        }

        public boolean isEmpty(){
            return s1.empty() && s2.empty();
        }
    }
}
