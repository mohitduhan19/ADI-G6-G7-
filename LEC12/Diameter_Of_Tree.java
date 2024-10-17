package LEC12;

import LEC11.Height_Binary_Tree;

public class Diameter_Of_Tree {
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
// static class Diapair{
//     int ht;
//     int dia;
// }
// public static Diapair Diameter1(Node node){
//     if(node == null){
//         Diapair bp = new Diapair();
//         bp.ht=-1;
//         bp.dia=0;
//         return bp;
//     }
//     Diapair lp = new Diameter1(node.left);
//     Diapair rp = new Diameter1(node.right);
//
//     Diapair mp = new Diapair();
//     mp.ht=Math.max(lp.ht , rp.ht) + 1;
//
//     int ans = lp.ht + rp.ht + 2;
//     mp.dia =Math.max(ans , Math.max(lp.dia , rp.dia));
// }
public int height(TreeNode node){
    if(node  == null)return -1;
    int lh =  height(node.left);
    int rh = height(node.right);
    int he = Math.max(lh , rh) + 1;
    return he;
}
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null)return -1;

        int ldia = diameterOfBinaryTree(root.left);
        int rdia = diameterOfBinaryTree(root.right);

        int lh= height(root.left);
        int rh = height(root.right);

        int dia = lh + rh + 2;
        return Math.max(dia , Math.max(ldia ,rdia));
    }
}
