package LEC4;
import java.util.*;
public class Combination_sum {
    public void helper(int[] nums , int tar ,List<List<Integer>> ans ,int idx ,   List<Integer> list){
        if(tar < 0)return;

        if(idx == nums.length || tar == 0){
            if(tar == 0){
                if(!ans.contains(list))ans.add(new ArrayList<>(list));
            }
            return;
        }

        list.add(nums[idx]);
        helper(nums , tar - nums[idx] , ans , idx  , list);
        list.remove(list.size()-1);
        helper(nums , tar , ans , idx + 1 , list);

    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        helper(candidates , target , ans , 0 , list );
        return ans;
    }
}
