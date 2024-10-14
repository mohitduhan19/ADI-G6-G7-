package LEC10;

public class Quick_Sort {
    public static void quickSort(int[] nums, int lo, int hi) {
        if (lo >= hi) return;
        int pivot = nums[hi];
        int pivotIdx = partitionArray(nums, pivot, lo, hi);
        quickSort(nums, lo, pivotIdx - 1); // Left of the pivot
        quickSort(nums, pivotIdx + 1, hi); // Right of the pivot
    }

    public static int partitionArray(int[] nums, int pivot, int lo, int hi) {
        int i = lo, j = lo;
        while (i <= hi) {
            if (nums[i] > pivot) {
                i++;
            } else {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j++;
            }
        }
        return j - 1; // Return the pivot index
    }

    public static void main(String[] args) {
        int[] nums = {7, 4, 1, 6, 8, 2};
        quickSort(nums, 0, nums.length - 1);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
