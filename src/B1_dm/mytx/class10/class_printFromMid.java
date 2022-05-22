package mytx.class10;

import java.util.ArrayList;
import java.util.List;

public class class_printFromMid {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int value){
            this.val = value;
            this.left=null;
            this.right = null;
        }

    }

    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null){
            return new ArrayList();
        }

        List<Integer> list = new ArrayList();
        dsf(root,list);
        return list;
    }
    private void dsf(TreeNode root,List<Integer> list){
        if(root ==null){
            return;
        }
        if(root.left!= null){
            dsf(root.left,list);
        }
        list.add(root.val);
        if(root.right != null){
            dsf(root.right,list);
        }
    }
}
