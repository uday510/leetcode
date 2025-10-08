class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) return Collections.singletonList(0);

        List<Integer>[] adjList = new ArrayList[n];

        for (int i = 0; i < n; i++) adjList[i] = new ArrayList<>();

        for (int[] e : edges) {
            int u = e[0], v = e[1];
            adjList[u].add(v);
            adjList[v].add(u);
        }

        Deque<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            if (adjList[i].size() == 1)
                queue.offerLast(i);
        }

        int rem = n;
        while (rem > 2) {
            rem -= queue.size();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int u = queue.pollFirst();
                int v = adjList[u].get(0);
                adjList[v].remove(Integer.valueOf(u));
                if (adjList[v].size() == 1) 
                    queue.offerLast(v);
            }
        }

        List<Integer> res = new ArrayList<>();

        for (int u : queue) res.add(u);

        return res;
    }
}
