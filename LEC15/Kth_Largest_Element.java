package LEC15;
import java.util.*;
public class Kth_Largest_Element {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i : nums){
            pq.add(i);
            if(pq.size() >k ){
                pq.remove();
            }
        }
        return pq.remove();
    }
}
