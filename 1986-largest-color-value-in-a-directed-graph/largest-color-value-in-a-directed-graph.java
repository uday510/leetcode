class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        List<Integer>[] adjList = new ArrayList[n];
        int[] inorder = new int[n];

        for (int i = 0; i < n; ++i) adjList[i] = new ArrayList<>();

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adjList[u].add(v);
            ++inorder[v];
        }

        int[][] dp = new int[n][128];

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; ++i) {
            if (inorder[i] == 0) queue.offer(i);
        }

        if (queue.isEmpty()) return -1;

        int vis = 0;
        int max = 1;

        while (!queue.isEmpty()) {
            int u = queue.poll();
            ++vis;
            char uColor = colors.charAt(u);
            dp[u][uColor]++;

            max = Math.max(max, dp[u][uColor]);

            for (int v : adjList[u]) {
                for (int i = 97; i < 128; ++i) {
                    dp[v][i] = Math.max(dp[u][i], dp[v][i]);
                }
                --inorder[v];

                if (inorder[v] != 0) continue;

                queue.offer(v);
            }
        }

        return vis < n ? -1 : max;
    }
}