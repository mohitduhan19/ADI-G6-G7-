package LEC10;

import java.util.ArrayList;
import java.util.List;

public class Merge_Sort {
    public static void mergeTwoSortedArray(int[]nums ,int low , int mid , int high){
        List<Integer> temp = new ArrayList<>();
        int left = low , right= mid+1;
        while(left <= mid && right <= high){
            if(nums[left] <= nums[right]){
                temp.add(nums[left]);
                left++;
            }else{
                temp.add(nums[right]);
                right++;
            }
        }

        while (left <= mid){
            temp.add(nums[left]);
            left++;
        }
        while (right <= high){
            temp.add(nums[right]);
            right++;
        }
        for (int i = low;i<=high;i++){
            nums[i] = temp.get(i-low);
        }
    }
    public static void merge(int[] nums , int low , int high){
        if(low == high)return;
        int mid = (low + high)/2;
        merge(nums , low ,mid);
        merge(nums , mid + 1  , high);
        mergeTwoSortedArray(nums , low , mid , high);
    }
    public static void mergesort(int[] nums , int n){
        merge(nums , 0 , n-1);
    }
    public static void main(String[] args) {
     int[] nums = { 7,4,1,6,8,2,5};
     mergesort(nums , nums.length);
     for(int i = 0;i < nums.length;i++){
         System.out.print(nums[i]);
     }

    }
}
