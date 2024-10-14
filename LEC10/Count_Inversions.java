package LEC10;

import java.util.ArrayList;
import java.util.List;

public class Count_Inversions {
    public static int merge(int nums[],int low,int high,int mid){
        int left=low;
        int right=mid+1;
        ArrayList<Integer> temp=new ArrayList<>();
        int count=0;
        while(left<=mid && right<=high){
            if(nums[left]<=nums[right]){
                temp.add(nums[left]);
                left++;
            }
            else{
                temp.add(nums[right]);
                count+=(mid-left+1); //if j is smaller than i then count increase
                right++;
            }
        }
        while(left<=mid){
            temp.add(nums[left]);
            left++;
        }
        while(right<=high){
            temp.add(nums[right]);
            right++;
        }
        for(int i=low;i<=high;i++){
            nums[i]=temp.get(i-low);
        }
        return count;
    }
    public static int mergeSort(int nums[],int low,int high){
        if(low>=high) return 0;
        int count=0;
        int mid=(low+high)/2;
        count+=mergeSort(nums,low,mid);
        count+=mergeSort(nums,mid+1,high);
        count+=merge(nums,low,high,mid);
        return count;
    }
   public static int mergesort(int nums[],int n){
       return mergeSort(nums,0,n-1);
   }
    public static void main(String[] args) {
        int[] nums = { 7,4,1,6,8,2,5};
        System.out.println(mergesort(nums , nums.length));
    }
}
