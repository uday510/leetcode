class Solution {
    public boolean canReach(int[] arr, int st) {
        
        int n = arr.length;
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] vis = new boolean[n];

        int dest = 0;
        vis[st] = true;
        queue.offer(st);

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (arr[cur] == dest) return true;


            for (int nxt : new int[] {cur + arr[cur], cur - arr[cur]}) {

                if (nxt < 0 || nxt >= n || vis[nxt]) continue;

                vis[nxt] = true;
                queue.offer(nxt);
            }
        }

        return false;
    }
}