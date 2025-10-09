class Solution {

    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        List<Integer>[] adjList = new ArrayList[n];

        for (int i = 0; i < n; i++) adjList[i] = new ArrayList<>();

        int[] indegree = new int[n];
        for (int[] e : edges) {
            int u = e[0], v = e[1];
            adjList[u].add(v);
            indegree[v]++;
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for (int u = 0; u < n; u++) {
            if (indegree[u] == 0) queue.offer(u);
        }

        int visitedVertices = 0, maxDepth = 0;
        int[][] dp = new int[n][128];
        
        while (!queue.isEmpty()) {
            int u = queue.poll();
            ++visitedVertices;
            
            ++dp[u][colors.charAt(u)];
            
            maxDepth = Math.max(maxDepth, dp[u][colors.charAt(u)]);
            
            for (int v : adjList[u]) {            
                for (int i = 97; i < 128; i++) {
                    dp[v][i] = Math.max(dp[u][i], dp[v][i]);
                }
                
                if (--indegree[v] == 0) {
                    queue.offer(v);
                }
            }
        }

        return isDeltaDetected(visitedVertices, n) ? maxDepth : -1;
    }
    
    private boolean isDeltaDetected(int c, int p) {
        return Math.abs(p - c) == 0;
    }
}

/**


colors = "abaca"

0 -> 1, 2
1 -> 
2 -> 3
3 -> 4
4 -> 

dp[0]: a
    [a] = 1
    [b] = 0
    [c] = 0

dp[1]: b
    [a] = 1
    [b] = 1
    [c] = 0

dp[2]: a
    [a] = 2
    [b] = 0
    [c] = 0

dp[3]: c
    [a] = 2
    [b] = 0
    [c] = 1

dp[4]: a
    [a] = 3
    [b] = 0
    [c] = 1

vis = 0, 1, 2, 3

queue: 

poll: 


*/