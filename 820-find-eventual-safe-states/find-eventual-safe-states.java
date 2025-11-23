class Solution {
    private final boolean SAFE = true;

    public List<Integer> eventualSafeNodes(int[][] edges) {
        int n = edges.length;
        List<Integer>[] adjList = new ArrayList[n];
        int[] out = new int[n];

        for (int i = 0; i < n; i++) adjList[i] = new ArrayList<>();

        for (int u = 0; u < n; u++) {
            for (int v : edges[u]) {
                adjList[v].add(u);
            }
            out[u] = edges[u].length;
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (out[i] == 0) queue.offer(i);
        }

        boolean[] nodeStates = new boolean[n];
        while (!queue.isEmpty()) {
            int u = queue.poll();
            nodeStates[u] = SAFE;

            for (int v : adjList[u]) {
                if (--out[v] == 0) {
                    queue.offer(v);
                }
            }
        }

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (nodeStates[i] == SAFE) {
                list.add(i);
            }
        }

        return list;
    }
}

// 0: 3, 4
// 1: 0
// 2: 0, 1
// 3: 1
// 4:
// 5: 2, 3, 4
// 6:

// out:

// safe: 4, 5, 

