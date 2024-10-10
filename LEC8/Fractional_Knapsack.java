package LEC8;
import java.util.*;
class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}
public class Fractional_Knapsack {
    double fractionalKnapsack(int W, Item arr[], int n)
    {
        Arrays.sort(arr, (a, b) -> Double.compare((double)b.value / b.weight,
                (double)a.value / a.weight));

        double sum =0;
        double maxWeight = W;
        for(int i=0;i<n;i++){
            if(arr[i].weight <= W){
                sum = sum+arr[i].value;
                W -= arr[i].weight;
            }else{
                sum +=(arr[i].value*1.0 / arr[i].weight)*W;
                W=0;
            }
        }
        return sum;
    }
}
