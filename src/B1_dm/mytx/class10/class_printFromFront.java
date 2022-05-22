package mytx.class10;


import java.util.Stack;

/**
 * 前序
 */
public class class_printFromFront {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    //递归形式
    public void print1(Node tree) {
        if (tree == null) {
            return;
        }
        System.out.println(tree.value);
        print1(tree.left);
        print1(tree.right);
    }

    //非递归形式 前序
    public void print2(Node tree) {
        if (tree == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(tree);
        while (stack.peek() != null) {
            Node node = stack.pop();
            System.out.println(node.value);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }
}
