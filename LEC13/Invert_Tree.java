package LEC13;

public class Invert_Tree {
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

    public TreeNode invertTree(TreeNode root) {
        if(root == null)return null;
        TreeNode node = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(node);

        return root;

    }
}
