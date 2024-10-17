package LEC12;
import java.util.*;
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
public class Binary_Tree_Left_View {
    ArrayList<Integer> leftView(Node root)
    {
        // Your code here
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node curr = q.poll();
                if (i == 0) {
                    res.add(curr.data);
                }
                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
        }
        return res;

    }

}
