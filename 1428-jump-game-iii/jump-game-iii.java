class Solution {
    public boolean canReach(int[] arr, int st) {
        int n = arr.length;
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] vis = new boolean[n];
        int dst = 0;

        vis[st] = true;
        queue.offer(st);

        while (!queue.isEmpty()) {
            int u = queue.poll();
            if (arr[u] == dst) return true;

            for (int v : getPaths(u, arr[u])) {
                if (!isValid(v, vis)) continue;

                vis[v] = true;
                queue.offer(v);
            }
        }

        return false;
    }

    private int[] getPaths(int u, int val) {
        return new int[] {u + val, u - val};
    }

    private boolean isValid(int v, boolean[] vis) {
        return v >= 0 && v < vis.length && !vis[v];
    }
}