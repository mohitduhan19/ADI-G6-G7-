package LEC9;
import java.util.*;
public class N_Meetings_In_A_Room {
    static class pair{
        int s;
        int e;
        pair(int s, int e){
            this.s = s;
            this.e =e;
        }
    }
    public static class MyComparator implements Comparator<pair>{
        public int compare(pair obj1 , pair obj2){
            return obj1.e - obj2.e;
        }
    }
    public static int maxMeetings(int start[], int end[], int n)
    {
        int ans = 0;

        pair[] arr = new pair[start.length];
        for(int i = 0; i < start.length;i++){
            arr[i] = new pair(start[i] , end[i]);
        }
        Arrays.sort(arr , new MyComparator());
        int c = 1 , onGoing = arr[0].e;
        for(int i = 1;i < arr.length;i++){
            if(arr[i].s > onGoing){
                c++;
                onGoing = arr[i].e;
            }
            else continue;
        }
        return c;

    }
}
