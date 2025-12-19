class Solution {
    public List<Integer> findAllPeople(int n, int[][] edges, int src) {
        // return applyDSU(n, edges, src);
        return applyDijsktra(n, edges, src);
    }

    private List<Integer> applyDSU(int n, int[][] edges, int src) {
        Arrays.sort(edges, Comparator.comparingInt(e -> e[2]));

        DSU dsu = new DSU(n);
        dsu.union(0, src);
        
        int u, v;
        for (int idx = 0; idx < edges.length;) {
            int w = edges[idx][2];
            List<int[]> batch = new ArrayList<>();

            
            while (idx < edges.length && w == edges[idx][2]) {
                u = edges[idx][0]; v = edges[idx][1];
                dsu.union(u, v);
                batch.add(edges[idx]);
                idx++;
            }

            for (int[] b : batch) {
                u = b[0]; v = b[1];
                if (!dsu.connected(src, u)) {
                    dsu.reset(u);
                    dsu.reset(v);
                }
            }
        }

        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (dsu.connected(src, i)) {
                res.add(i);
            }
        }

        return res;
    }
    
    private List<Integer> applyDijsktra(int n, int[][] edges, int src) {
        List<int[]>[] adjList = new ArrayList[n];

        for (int i = 0; i < n; i++) adjList[i] = new ArrayList<>();

        int u, v, w;
        for (int[] e : edges) {
            u = e[0]; v = e[1]; w = e[2];
            adjList[u].add(new int[]{v, w});
            adjList[v].add(new int[]{u, w});
        }

        adjList[0].add(new int[]{src, 0});
        // adjList[src].add(new int[]{0, 0});
        
        int[] dist = new int[n];
        Arrays.fill(dist, (int) 1e9);

        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(k -> k[1]));
        pq.offer(new int[]{0, 0});
        dist[0] = 0;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            u = cur[0]; w = cur[1];
            if (w > dist[u]) continue;

            for (int[] nxt : adjList[u]) {
                v = nxt[0]; 
                int w1 = nxt[1];

                if (w1 >= w && w1 < dist[v]) {
                    dist[v] = w1;
                    pq.offer(new int[]{v, w1});
                }
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (dist[i] != (int) 1e9) res.add(i);
        }

        return res;
    }

}

class DSU {
    int[] root, rank;
    
    DSU (int n) {
        root = new int[n];
        rank = new int[n];

        for (int i = 0; i < n; i++) {
            root[i] = i;
            rank[i] = 1;
        }

    }

    void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX == rootY) return;

        if (rank[rootX] > rank[rootY]) {
            root[rootY] = rootX;
        } else if (rank[rootY] > rank[rootX]) {
            root[rootX] = rootY;
        } else {
            rank[rootX] += 1;
            root[rootY] = rootX;
        }
    }

    int find(int x) {
        if (x == root[x]) 
            return x;
        return root[x] = find(root[x]);
    }

    boolean connected(int x, int y) {
        return find(x) == find(y);
    }

    void reset(int x) {
        root[x] = x;
        rank[x] = 1;
    }
}