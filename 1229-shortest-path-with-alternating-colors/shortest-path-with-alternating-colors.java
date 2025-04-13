class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        int[][] visited = new int[n][2];
        Queue<int[]> queue = new ArrayDeque<>();
        List<int[]>[] adjList = new ArrayList[n];
        int[] distance = new int[n];
        
        Arrays.fill(distance, -1);
        for (int i = 0; i < n; ++i) adjList[i] = new ArrayList<>();
        
        for (int[] edge : redEdges) {
            adjList[edge[0]].add(new int[]{edge[1], 0});
        }

        for (int[] edge : blueEdges) {
            adjList[edge[0]].add(new int[]{edge[1], 1});
        }

        queue.offer(new int[]{0, 0, -1});
        visited[0][0] = 1;
        distance[0] = 0;

        while (!queue.isEmpty()) {
            int[] arr = queue.poll();
            int node = arr[0], steps = arr[1], prevColor = arr[2];

            for (int[] neiNode : adjList[node]) {
                int nei = neiNode[0];
                int currColor = neiNode[1];

                if (visited[nei][currColor] == 1 || currColor == prevColor) continue;

                queue.offer(new int[]{ nei, 1 + steps, currColor });

                visited[nei][currColor] = 1;
                
                if (distance[nei] == -1) distance[nei] = 1 + steps;
            }
        }

        return distance;
    }
}