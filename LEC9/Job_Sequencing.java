package LEC9;
import java.util.*;
class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z;
    }
}
public class Job_Sequencing {
    public class MyComparator implements Comparator<Job>{
        public int compare(Job obj1 , Job obj2){
            return obj2.profit - obj1.profit;
        }
    }
    int[] JobScheduling(Job arr[], int n)
    {
        // Your code here
        Arrays.sort(arr , new MyComparator());
        int m = 0;
        for(int i = 0; i < arr.length;i++){
            m = Math.max(m , arr[i].deadline);
        }
        boolean[] nums = new boolean[m];
        int ans = 0, c = 0;
        for(int i = 0;i < arr.length;i++){
            for(int j = arr[i].deadline - 1 ;j >= 0;j--){
                if(nums[j] == false){
                    nums[j] = true;
                    ans += arr[i].profit;
                    c++;
                    break;
                }
            }
        }

        return new int[]{c , ans};
    }
}
