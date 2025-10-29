import java.util.*;

class Solution {

    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        int m = edges.length;
        int[][] newEdges = new int[m][4];

        for (int i = 0; i < m; i++) {
            newEdges[i][0] = edges[i][0];
            newEdges[i][1] = edges[i][1];
            newEdges[i][2] = edges[i][2];
            newEdges[i][3] = i;
        }

        Arrays.sort(newEdges, Comparator.comparingInt(e -> e[2]));

        int mstWeight = kruskal(newEdges, n, m, -1, -1);

        List<Integer> criticalEdges = new ArrayList<>();
        List<Integer> pseudoCriticalEdges = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            int excWeight = kruskal(newEdges, n, m, i, -1);
            if (excWeight > mstWeight) {
                criticalEdges.add(newEdges[i][3]);
            } else {
                int incWeight = kruskal(newEdges, n, m, -1, i);
                if (incWeight == mstWeight) {
                    pseudoCriticalEdges.add(newEdges[i][3]);
                }
            }
        }

        return Arrays.asList(criticalEdges, pseudoCriticalEdges); 
    }

    private int kruskal(int[][] edges, int n, int m, int exc, int inc) {
        UnionFind uf = new UnionFind(n);
        int weight = 0;
        int edgesCnt = 0;

        if (inc != -1) {
            int[] e = edges[inc];
            uf.union(e[0], e[1]);
            weight += e[2];
            edgesCnt++;
        }

        for (int i = 0; i < m; i++) {
            if (i == exc) continue;
            int[] edge = edges[i];
            int u = edge[0], v = edge[1], w = edge[2];

            if (!uf.connected(u, v)) {
                uf.union(u, v);
                weight += w;
                edgesCnt++;
            }
        }

        return edgesCnt == n - 1 ? weight : Integer.MAX_VALUE;

    }
}


class UnionFind {
    int[] root, rank;

    UnionFind(int n) {
        root = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            root[i] = i;
            rank[i] = 1;
        }
    }

    int find(int x) {
        if (x != root[x])
            root[x] = find(root[x]);
        return root[x];
    }

    void union(int x, int y) {
        int rootX = find(x), rootY = find(y);
        if (rootX == rootY) return;

        if (rank[rootX] > rank[rootY]) {
            root[rootY] = rootX;
        } else if (rank[rootY] > rank[rootX]) {
            root[rootX] = rootY;
        } else {
            root[rootY] = rootX;
            rank[rootX]++;
        }
    }

    boolean connected(int x, int y) {
        return find(x) == find(y);
    }
}
