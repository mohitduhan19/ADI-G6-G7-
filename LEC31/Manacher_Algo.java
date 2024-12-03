package LEC31;

public class Manacher_Algo {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";

        // Convert the string to a modified character array with delimiters
        char[] nums = s.toCharArray();
        char[] arr = new char[2 * nums.length + 1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (i % 2 == 0) ? '#' : nums[i / 2];
        }

        // Array to store the palindrome lengths
        int[] temp = new int[arr.length];
        int center = 0, right = 0;
        int maxLen = 0, centerIndex = 0;

        for (int i = 0; i < arr.length; i++) {
            int mirror = 2 * center - i;

            if (i < right) {
                temp[i] = Math.min(right - i, temp[mirror]);
            }

            int a = i + temp[i] + 1;
            int b = i - temp[i] - 1;

            while (a < arr.length && b >= 0 && arr[a] == arr[b]) {
                temp[i]++;
                a++;
                b--;
            }

            if (i + temp[i] > right) {
                center = i;
                right = i + temp[i];
            }

            if (temp[i] > maxLen) {
                maxLen = temp[i];
                centerIndex = i;
            }
        }

        int start = (centerIndex - maxLen) / 2;
        return s.substring(start, start + maxLen);
    }
}
