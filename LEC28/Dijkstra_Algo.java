package LEC28;
import java.util.*;
class iPair {
    int first, second;

    iPair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}
public class Dijkstra_Algo {
    ArrayList<Integer> dijkstra(ArrayList<ArrayList<iPair>> adj, int src) {
        int V = adj.size();
        ArrayList<Integer> dist = new ArrayList<>();
        for (int i = 0; i < V; i++) dist.add(Integer.MAX_VALUE);

        dist.set(src, 0);
        PriorityQueue<iPair> pq = new PriorityQueue<>((a, b) -> a.second - b.second);
        for (int i = 0; i < adj.size(); i++) {
            if (i == src)
                pq.add(new iPair(src, 0));
            else
                pq.add(new iPair(i, Integer.MAX_VALUE));
        }
        while (!pq.isEmpty()) {
            iPair node = pq.poll();
            int u = node.first;
            for (iPair it : adj.get(u)) {
                if (dist.get(it.first) > dist.get(u) + it.second) {
                    dist.set(it.first, dist.get(u) + it.second);
                    pq.add(new iPair(it.first, dist.get(it.first)));
                }
            }
        }
        return dist;
    }
}
