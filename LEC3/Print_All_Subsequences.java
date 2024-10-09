package LEC3;
import java.util.*;
public class Print_All_Subsequences {
    public static void printSubsequences(int[] arr, int index, List<Integer> current) {
        if (index == arr.length) {
            System.out.println(current);
            return;
        }

        current.add(arr[index]);
        printSubsequences(arr, index + 1, current);
        current.remove(current.size() - 1);
        printSubsequences(arr, index + 1, current);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        List<Integer> current = new ArrayList<>();

        System.out.println("All Subsequences of the array:");
        printSubsequences(arr, 0, current);
    }
}
