package LEC14;

public class Insertion_BST {
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

    public static TreeNode add(TreeNode node , int data){
        if(node == null){
            return new TreeNode(data , null , null);
        }
        if(data > node.val){
            node.right = add(node.right , data);
        }else if(data < node.val){
            node.left = add(node.left , data);
        }
        return node;
    }
}
