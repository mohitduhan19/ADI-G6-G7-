package LEC12;
import LEC11.Height_Binary_Tree;

import java.util.*;
public class BInary_Tree_Right_View {
    public static class TreeNode {
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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) return new ArrayList<>();
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        while(q.size() != 0){
            int size = q.size();
            ans.add(q.peek().val);
            while(size-- > 0){

                TreeNode node = q.remove();
                if(node.right != null)q.add(node.right);
                if(node.left != null)q.add(node.left);
            }
        }
        return ans;
    }

}
