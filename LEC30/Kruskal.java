package LEC30;
import java.util.*;
public class Kruskal {
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        List<Edge> edges = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            List<int[]> list = adj.get(i);

            for (int j = 0; j < list.size(); j++) {
                int src = i;
                int dest = list.get(j)[0];
                int wt = list.get(j)[1];

                edges.add(new Edge(src, dest, wt));
            }
        }

        Collections.sort(edges, (A, B) -> { return A.wt - B.wt; });

        DSU ds = new DSU(V);
        int mstWt = 0;

        for (Edge it : edges) {
            if (!ds.same(it.src, it.dest)) {
                mstWt += it.wt;
            }
            ds.merge(it.src, it.dest);
        }

        return mstWt;
    }
}

class Edge {
    int src;
    int dest;
    int wt;

    Edge(int src, int dest, int wt) {
        this.src = src;
        this.dest = dest;
        this.wt = wt;
    }
}

class DSU {
    private int n;
    private int[] parentOrSize;

    public DSU(int n) {
        this.n = n;
        this.parentOrSize = new int[n];
        java.util.Arrays.fill(parentOrSize, -1);
    }

    int merge(int a, int b) {
        if (!(0 <= a && a < n)) throw new IndexOutOfBoundsException("a=" + a);
        if (!(0 <= b && b < n)) throw new IndexOutOfBoundsException("b=" + b);

        int x = leader(a);
        int y = leader(b);
        if (x == y) return x;
        if (-parentOrSize[x] < -parentOrSize[y]) {
            int tmp = x;
            x = y;
            y = tmp;
        }
        parentOrSize[x] += parentOrSize[y];
        parentOrSize[y] = x;
        return x;
    }

    boolean same(int a, int b) {
        if (!(0 <= a && a < n)) throw new IndexOutOfBoundsException("a=" + a);
        if (!(0 <= b && b < n)) throw new IndexOutOfBoundsException("b=" + b);
        return leader(a) == leader(b);
    }

    int leader(int a) {
        if (parentOrSize[a] < 0) {
            return a;
        } else {
            parentOrSize[a] = leader(parentOrSize[a]);
            return parentOrSize[a];
        }
    }
}
