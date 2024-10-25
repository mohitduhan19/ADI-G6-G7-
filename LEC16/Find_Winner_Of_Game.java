package LEC16;
import java.util.*;
public class Find_Winner_Of_Game {
    static int digit_sum(int n)
    {
        int s = 0;
        while (n > 0) {
            s += n % 10;
            n /= 10;
        }
        return s;
    }
    static String findTheWinner(int arr[], int n)
    {

        int arr1[][] = new int[arr.length][2];
        for(int i=0;i<arr.length;i++){
            arr1[i][0] = arr[i];
            arr1[i][1] = digit_sum(arr[i]);
        }
        Arrays.sort(arr1,(a,b)->a[0]-b[0]);
        int scoreA = 0;
        for (int i = n - 1; i >= 0; i -= 2)
            scoreA += arr1[i][0];
        int scoreB = 0;
        for (int i = n - 2; i >= 0; i -= 2)
            scoreB += arr1[i][0];

        if (scoreA == scoreB)
            return "Draw";
        else if (scoreA > scoreB)
            return "A";
        return "B";
    }

}
