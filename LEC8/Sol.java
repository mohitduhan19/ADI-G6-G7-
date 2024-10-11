package LEC8;

import java.util.*;

public class Sol {
    public static void backtrack(List<List<Integer>> res , int[] nums , List<Integer>curr , boolean[] visited){
        if(curr.size() == nums.length ){
            if(!res.contains(curr)){
                res.add(new ArrayList<>(curr));
                return ;
            }
        }

        for(int i = 0; i < nums.length;i++){
            if(visited[i] == true)continue;
            visited[i] = true;
            curr.add(nums[i]);
            backtrack(res , nums, curr , visited);
            curr.remove(curr.size() - 1);
            visited[i] = false;

        }
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>>res = new ArrayList<>();
        boolean[]visited = new boolean[nums.length];
        backtrack(res , nums , new ArrayList<>() , visited);
        return res;
    }
    public static void main(String[] args) {
        Sol main = new Sol();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        List<List<Integer>> result = main.permuteUnique(nums);
        for (List<Integer> perm : result) {
            System.out.println(perm);
        }
    }
}
