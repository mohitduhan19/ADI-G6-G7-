package LEC11;

public class Check_Balanced_Binary_Tree {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public int height(TreeNode root){
        if(root == null)return 0;
        int lh = height(root.left);
        int rh = height(root.right);

        if(lh == -1 || rh == -1 || Math.abs(lh-rh) > 1)return -1;
        return Math.max(lh , rh) + 1;
    }
    public boolean isBalanced(TreeNode root) {
        if(root == null)return true;
        return height(root) < 0 ? false:true;
    }
}
