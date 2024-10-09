package LEC3;
import java.util.*;
public class print_all_subsequence_sum_equal_to_k {
    public static void printSubsequences(int[] arr, int index, List<Integer> current, int k, int currentSum) {
        if (index == arr.length) {
            if (currentSum == k) {
                System.out.println(current);
            }
            return;
        }
        current.add(arr[index]);
        printSubsequences(arr, index + 1, current, k, currentSum + arr[index]);
        current.remove(current.size() - 1);
        printSubsequences(arr, index + 1, current, k, currentSum);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        int k = 3;
        List<Integer> current = new ArrayList<>();

        System.out.println("Subsequences with sum equal to " + k + ":");
        printSubsequences(arr, 0, current, k, 0);
    }
}
