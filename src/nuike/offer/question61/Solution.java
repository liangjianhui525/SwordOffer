package nuike.offer.question61;

/**
 * Created by Administrator on 2017/7/18.
 */

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}

public class Solution {
    int index = -1;
    String Serialize(TreeNode root) {

        StringBuffer sb = new StringBuffer();
        if(root== null){
            sb.append("#,");
        }
        sb.append(root.val).append(",");
        sb.append(Serialize(root.left));
        sb.append(Serialize(root.right));
        return sb.toString();

    }

    TreeNode Deserialize(String str) {
        index++;
        String[] st = str.split(",");
        TreeNode node = null;
        if(!st[index].equals("#")){
            node = new TreeNode(Integer.valueOf(st[index]));
            node.left = Deserialize(str);
            node.right = Deserialize(str);
        }
        return node;
    }
}
