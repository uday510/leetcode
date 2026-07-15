class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] vis = new boolean[n];


        Queue<Integer> queue = new ArrayDeque<>();
        vis[0] = true;
        queue.offer(0);
        int cnt = 0;

        while (!queue.isEmpty()) {
            int u = queue.poll();
            cnt++;

            for (int v : rooms.get(u)) {
                if (vis[v]) continue;

                vis[v] = true;
                queue.offer(v);
            }
        }


        return cnt == n;
    }
}