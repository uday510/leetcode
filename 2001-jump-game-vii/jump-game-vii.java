class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] vis = new boolean[n];
        vis[0] = true;
        queue.offer(0);

        int farthest = 0;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (cur == n - 1) return true;

            int mx = Math.min(cur + maxJump, n - 1);

            for (int j = Math.max(cur + minJump, farthest + 1); j <= mx; j++) {
                if (s.charAt(j) == '0' && !vis[j]) {
                    vis[j] = true;
                    queue.offer(j);
                }
                
                farthest = Math.max(farthest, mx);
            }
        }

        return vis[n - 1];
    }
}