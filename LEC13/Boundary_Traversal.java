package LEC13;
import java.util.*;
public class Boundary_Traversal {
    static class Node
    {
        int data;
        Node left, right;

        public Node(int d)
        {
            data = d;
            left = right = null;
        }
    }

    boolean isLeaf(Node node){
        if(node.left == null && node.right == null)return true;
        return false;
    }
    void leftbound(Node node , ArrayList <Integer> ans){
        Node curr = node.left;
        while(curr != null){
            if(isLeaf(curr) == false){
                ans.add(curr.data);
            }
            if(curr.left != null)curr = curr.left;
            else curr = curr.right;
        }
    }

    void rightbound(Node node , ArrayList <Integer> ans){
        Node curr = node.right;
        ArrayList <Integer> temp = new ArrayList <>();
        while(curr != null){
            if(isLeaf(curr) == false){
                temp.add(curr.data);
            }
            if(curr.right != null)curr = curr.right;
            else curr = curr.left;
        }
        for(int i = temp.size()-1; i>= 0;i--)ans.add(temp.get(i));
    }

    void addleaf(Node node , ArrayList <Integer> ans){
        if(isLeaf(node)){
            ans.add(node.data);
            return;
        }

        if(node.left != null)addleaf(node.left , ans);
        if(node.right != null)addleaf(node.right , ans);
    }
    ArrayList <Integer> boundary(Node node)
    {
        ArrayList<Integer> ans = new ArrayList<>();

        if(isLeaf(node) == false)ans.add(node.data);
        leftbound(node , ans);
        addleaf(node , ans);
        rightbound(node , ans);
        return ans;
    }
}
