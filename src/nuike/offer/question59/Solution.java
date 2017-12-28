package nuike.offer.question59;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}

public class Solution {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(pRoot==null){
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        TreeNode last=pRoot;
        TreeNode cur = null;
        queue.offer(pRoot);
        while (!queue.isEmpty()){
            pRoot = queue.poll();
            arrayList.add(pRoot.val);
            if(pRoot.left!=null){
                queue.offer(pRoot.left);
                cur = pRoot.left;
            }
            if (pRoot.right!=null){
                queue.offer(pRoot.right);
                cur = pRoot.right;
            }
            if(pRoot==last){
                result.add(arrayList);
                last= cur;
                arrayList = new ArrayList<>();
            }
        }


        return result;
    }



}
