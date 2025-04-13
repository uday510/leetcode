class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new ArrayDeque<>();
        List<Integer>[] adjList = new ArrayList[n];

        for (int i = 0; i < n; ++i) {
            adjList[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adjList[u].add(v);
            adjList[v].add(u);
        }

        queue.offer(source);
        visited.add(source);

        while (!queue.isEmpty()) {
            int node = queue.poll();

           if (node == destination) return true;

            for (int neighbor : adjList[node]) {
                    if (visited.add(neighbor)) {
                        queue.add(neighbor);
                    }
                }
        }

        return false;
    }
}