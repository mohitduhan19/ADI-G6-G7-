package LEC12;

import LEC11.Height_Binary_Tree;

public class Binary_Tree_Tilt {
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
    private int tilt = 0;
    public int find(TreeNode root){
        if(root == null)return 0;
        int ls = find(root.left);
        int rs = find(root.right);

        int tiltNode = Math.abs(ls - rs);
        tilt += tiltNode;
        return ls + rs + root.val;
    }
    public int findTilt(TreeNode root) {
        tilt = 0;
        find(root);
        return tilt;
    }
}
