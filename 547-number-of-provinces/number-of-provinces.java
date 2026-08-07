class Solution {
    public int findCircleNum(int[][] edges) {
        
        int n = edges.length;
        boolean[] vis = new boolean[n + 1];
        int total = 0;

        for (int i = 0; i < n; i++) {
            if (vis[i]) continue;

            total++;
            Queue<Integer> queue = new ArrayDeque<>();

            vis[i] = true;
            queue.offer(i);
            
            while (!queue.isEmpty()) {

                int cur = queue.poll();
                for (int j = 0; j < edges[cur].length; j++) {
                    if (cur == j || edges[cur][j] == 0 || vis[j]) continue;

                    vis[j] = true;
                    queue.offer(j);
                }
            }
        }

        return total;

    }
}