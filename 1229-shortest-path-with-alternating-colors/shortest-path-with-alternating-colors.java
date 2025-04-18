class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        List<int[]>[] adjList = new ArrayList[n];
        for (int i = 0; i < n; ++i) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < redEdges.length; ++i) {
           int u = redEdges[i][0];
           int v = redEdges[i][1];
           adjList[u].add(new int[]{v, 0});
        }

        for (int i = 0; i < blueEdges.length; ++i) {
            int u = blueEdges[i][0];
            int v = blueEdges[i][1];
            adjList[u].add(new int[]{v, 1});
        }

        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][2];
        int[] distance = new int[n];
        
        queue.offer(new int[]{0, 0, -1});
        visited[0][0] = visited[0][1] = true;
        Arrays.fill(distance, -1);
        distance[0] = 0;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int node = curr[0];
            int dist = curr[1];
            int prevColor = curr[2];

            for (int[] next : adjList[node]) {
                int nextNode = next[0];
                int nextColor = next[1];

                if (visited[nextNode][nextColor] || prevColor == nextColor) {
                    continue;
                }

                queue.offer(new int[]{nextNode, dist + 1, nextColor});
                if (distance[nextNode] == -1 ) distance[nextNode] = 1 + dist;
                visited[nextNode][nextColor] = true;
            }
        }

        return distance;
    }
}