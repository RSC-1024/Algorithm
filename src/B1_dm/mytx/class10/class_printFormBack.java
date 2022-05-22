package mytx.class10;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class class_printFormBack {
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int data) {
            this.val = data;
        }
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null){
            return new ArrayList() ;
        }
        List<Integer> list = new ArrayList();
        getOrder(root,list);
        return list;
    }
    public void getOrder(TreeNode node,List<Integer>  list){
        if(node==null){
            return ;
        }
        if(node.left!=null){
            getOrder(node.left,list);
        }
        if(node.right!= null){
            getOrder(node.right,list);
        }
        list.add(node.val);
    }

    //用非递归方式写后序
    public List<Integer> getOrder(TreeNode treeNode){
        if (treeNode ==null){
            return new ArrayList<>();
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Stack<TreeNode> ans = new Stack<TreeNode>();
        stack.push(treeNode);
        while (stack.peek()!=null){
            TreeNode node = stack.pop();
            if (node.left!=null){
                stack.push(node.left);
            }
            if (node.right!=null){
                stack.push(node.right);
            }
            ans.push(node);
        }
        List<Integer> list= new ArrayList<>();
        while (stack.peek()!=null){
            list.add(stack.pop().val);
        }
        return list;
    }
}
