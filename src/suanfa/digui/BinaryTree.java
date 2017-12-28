package suanfa.digui;

import java.util.Stack;

/**
 * Created by Administrator on 2017/8/16.
 */
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int val,TreeNode left,TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}



public class BinaryTree {
    public static void preOrder(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        while(root!=null || stack.isEmpty()){
            while (root!=null){
                System.out.print(root.val + " ");
                stack.add(root);
                root = root.left;
            }
            if (!stack.isEmpty()){
                root = stack.pop();
                root = root.right;
            }
        }
    }

    public static void InOrder(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        while(root!=null || stack.isEmpty()){
            while (root!=null){
                stack.add(root);
                root = root.left;
            }
            if (!stack.isEmpty()){
                root = stack.pop();
                System.out.print(root.val+" ");
                root = root.right;
            }
        }
    }

    public static void PosOrder(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = root;
        while(root!=null || stack.isEmpty()){
            while (root!=null){
                stack.add(root);
                root = root.left;
            }
            if (!stack.isEmpty()){
                TreeNode temp = stack.peek().right;
                if(temp==null || temp == pre){
                    root = stack.pop();
                    System.out.println(root.val+" ");
                    pre = root;
                    root = null;
                }else {
                    root = temp;
                }
            }
        }
    }

}
