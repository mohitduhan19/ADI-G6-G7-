package LEC11;
import java.util.*;

public class Level_Order_Trav {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null)return new ArrayList<>();

        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);

        while(q.size() > 0){
            List<Integer> temp = new ArrayList<>();
            int size = q.size();
            for(int i = 0; i < size;i++){
                if(q.peek().left != null)q.add(q.peek().left);
                if(q.peek().right != null)q.add(q.peek().right);
                temp.add(q.remove().val);
            }
            ans.add(temp);
        }
        return ans;
    }
}
