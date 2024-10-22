package LEC15;

import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Merge_K_Sorted_List {
    static class pair implements Comparable<pair>{
        int li;
        int di;
        int val;
        pair(int li , int di , int val){
            this.li=li;
            this.di=di;
            this.val=val;
        }
        public int compareTo(pair o){
            return this.val-o.val;
        }
    }
    public static List<Integer> merge(List<List<Integer>> arr){
        List<Integer>ans = new ArrayList<>();
        PriorityQueue pq = new PriorityQueue();
        for(int i = 0;i<arr.size();i++){
            pair p = new pair(i , 0 ,arr.get(i).get(0));
            pq.add(p);
        }
        while (pq.size()>0){
            pair p = (pair) pq.remove();
            ans.add(p.val);
            p.di++;
            if(p.di < arr.get(p.li).size()){
                p.val=arr.get(p.li).get(p.di);
                pq.add(p);
            }
        }
        return ans;
    }
    public static void main(String[] args) {

    }
}
