class Solution {
    
    List<Integer>[] adjList;
    int[] time;

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        adjList = new ArrayList[n];
        this.time = informTime;
        
        for (int i = 0; i < n; i++) adjList[i] = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (manager[i] != -1) {
                adjList[manager[i]].add(i);
            }
        }

        // return dfs(headID);

        Queue<int[]> queue = new ArrayDeque<>();
        int dist = 0;

        queue.offer(new int[] {headID, 0});
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int u = cur[0], w = cur[1];
            dist = Math.max(dist, w);

            for (int v : adjList[u]) {
                queue.offer(new int[] {v, w + time[u]});
            }
        }

        return dist;
    }

    private int dfs(int u) {
        int dist = 0;

        for (int v : adjList[u]) {
            dist = Math.max(dist, dfs(v));
        }

        return dist + time[u];
    }
}

/**


Input: n = 6, headID = 2, manager = [2,2,-1,2,2,2], informTime = [0,0,1,0,0,0]


2 -> 0, 1, 3, 4, 5




*/