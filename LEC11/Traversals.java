package LEC11;
import java.util.*;
public class Traversals {
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
    public void preorder(TreeNode root , List<Integer> ans){
        if(root == null)return;
        ans.add(root.val);
        preorder(root.left , ans);
        preorder(root.right , ans);
    }
    public void postorder(TreeNode root , List<Integer> ans){
        if(root == null)return;
        postorder(root.left , ans);
        postorder(root.right , ans);
        ans.add(root.val);
    }
    public void inorder(TreeNode root , List<Integer> ans){
        if(root == null)return;
        inorder(root.left , ans);
        ans.add(root.val);
        inorder(root.right , ans);
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root == null)return new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        preorder(root , ans);
        return ans;
    }
}
