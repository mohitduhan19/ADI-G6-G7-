package LEC30;
import java.util.*;
public class Disjoint_Set {
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    public Disjoint_Set(int n){
        for(int i = 0;i <=n;i++){
            rank.add(0);
            parent.add(i);
        }
    }
    public int findGreatParent(int node){
        if(node == parent.get(node))return node;
        int gp = findGreatParent(parent.get(node));
        return parent.get(node);
    }
    public void unionByRank(int u , int v){
        int gp_u = findGreatParent(u);
        int gp_v = findGreatParent(v);

        if(gp_u == gp_v)return;
        if(rank.get(gp_u) < rank.get(gp_v)){
            parent.set(gp_u , gp_v);
        }else if(rank.get(gp_v) < rank.get(gp_u)){
            parent.set(gp_v ,gp_v);
        }else{
            parent.set(gp_v , gp_u);
            int rankU = rank.get(gp_u);
            rank.set(gp_u , rankU + 1);
        }
    }
}
