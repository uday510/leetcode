class Solution {
    public int minJumps(int[] arr) {
        if (arr.length <= 1) return 0;

        int n = arr.length, src = 0, dest = n - 1;
        Map<Integer, List<Integer>> adj = new HashMap<>();
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] vis = new boolean[n];

        for (int i = 0; i < n; i++) 
            adj.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);

        vis[src] = true;
        queue.offer(src);

        int jumps = 0;

        while (!queue.isEmpty()) {
            jumps++;

            int sz = queue.size();

            for (int i = 0; i < sz; i++) {
                int cur = queue.poll();

                for (int v : getNextJumps(cur, vis, arr, adj)) {
                    if (v == dest) return jumps;

                    vis[v] = true;
                    queue.offer(v);
                }
            }

        }

        return -1;

    }

    private List<Integer> getNextJumps(
        int u, 
        boolean[] vis, 
        int[] arr, 
        Map<Integer, List<Integer>> adj
        ) {

        List<Integer> list = new ArrayList<>();

        if (u + 1 < arr.length && !vis[u + 1]) list.add(u + 1);
        if (u - 1 > -1 && !vis[u - 1]) list.add(u - 1);

        if (adj.get(arr[u]) == null) return list;

        for (int v : adj.get(arr[u])) {
            if (!vis[v]) list.add(v);
        }

        adj.remove(arr[u]);

        return list;

    }

}