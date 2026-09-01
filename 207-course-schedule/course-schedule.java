class Solution {
    public boolean canFinish(int n, int[][] pre) {
        List<Integer>[] adj = new ArrayList[n];
        int[] inorder = new int[n];

        for (int i = 0; i < n; i++) 
            adj[i] = new ArrayList<>();
        
        for (int[] p : pre) {
            int u = p[1], v = p[0];
            adj[u].add(v);
            inorder[v]++;
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (inorder[i] == 0) {
                queue.offer(i);
            }
        }

        int total = 0;
        while (!queue.isEmpty()) {
            total++;
            int u = queue.poll();
            for (int v : adj[u]) {
                if (--inorder[v] == 0) {
                    queue.offer(v);
                }
            }
        }

        return total == n;
    }
}