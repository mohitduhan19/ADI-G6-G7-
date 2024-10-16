package LEC11;

public class Same_Tree {
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
    /* public boolean help(TreeNode p,TreeNode q){
     if(p == null && q == null)return true;
     if(p == null || q == null)return false;

     if(p.val != q.val)return false;
     boolean l = help(p.left , q.left);
     boolean r = help(p.right ,  q.right);
     return l && r;
 }*/
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // return help(p , q);

        return (p.val == q.val) && isSameTree(p.left ,q.left) &&isSameTree(p.right , q.right);
    }
}
