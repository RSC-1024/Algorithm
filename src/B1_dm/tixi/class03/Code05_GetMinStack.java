package tixi.class03;

import java.util.Stack;

public class Code05_GetMinStack {


    static class MinStack {
        Stack<Integer> minStack;
        Stack<Integer> dataStack;

        public MinStack(Integer t) {
            this.minStack = new Stack<Integer>();
            this.dataStack = new Stack<Integer>();
        }

        public void push(Integer val) {
            this.dataStack.push(val);
            if (this.minStack.isEmpty() || val <= this.minStack.peek()) {
                this.minStack.push(val);
            }
        }

        public int pop() {
            if (this.dataStack.isEmpty()) {
                throw new RuntimeException("stack is empty, can not pop ");
            }
            int ans = this.dataStack.pop();
            if (ans == this.minStack.peek()) {
                this.minStack.pop();
            }
            return ans;
        }

        public int top() {
            if (this.dataStack.isEmpty()) {
                throw new RuntimeException("stack is empty, can not top ");
            }
            return this.dataStack.peek();
        }

        public int getMin() {
            if (this.minStack.isEmpty()){
                throw  new RuntimeException("stack is empty,can not getMin");
            }
            return this.minStack.peek();
        }
    }
}
