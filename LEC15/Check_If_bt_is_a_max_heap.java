package LEC15;

import java.util.ArrayDeque;
import java.util.Queue;

public class Check_If_bt_is_a_max_heap {
    static class Node {
        Node left;
        Node right;
        int data;

        Node(Node left, Node right, int data) {
            this.left = left;
            this.right = right;
            this.data = data;
        }
    }
    static boolean isHeap(Node root) {
        Queue<Node> q = new ArrayDeque<>();
        if (root == null) return true;
        q.add(root);
        boolean seen = false;

        while (!q.isEmpty()) {
            Node temp = q.poll();
            if (temp.left != null) {
                if (seen || temp.left.data > temp.data) return false;
                q.add(temp.left);
            } else {
                seen = true;
            }
            if (temp.right != null) {
                if (seen || temp.right.data > temp.data) return false;
                q.add(temp.right);
            } else {
                seen = true;
            }

        }
        return true;
    }
}
