package LEC14;

public class Validate_BST {
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

    public boolean isvalid(TreeNode root ,long minval , long maxval){
        if(root == null)return true;
        if(root.val >= maxval || root.val <= minval)return false;
        return isvalid(root.left , minval ,root.val) && isvalid(root.right
                , root.val , maxval);
    }
    public boolean isValidBST(TreeNode root) {
        return isvalid(root , Long.MIN_VALUE , Long.MAX_VALUE);
    }
}
