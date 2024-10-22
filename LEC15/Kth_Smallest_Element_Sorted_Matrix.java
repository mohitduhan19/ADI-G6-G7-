package LEC15;
import java.util.*;
public class Kth_Smallest_Element_Sorted_Matrix {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                pq.add(matrix[i][j]);
            }
        }
        while(k-- >1){
            if(pq.size()>k){
                pq.remove();
            }
        }
        return pq.remove();
    }
}
