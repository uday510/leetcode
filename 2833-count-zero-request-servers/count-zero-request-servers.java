class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        int m = queries.length;
        List<int[]> ls = new ArrayList<>();
        List<int[]> qs = new ArrayList<>();

        for (int[] l : logs)    
            ls.add(new int[] {l[1], l[0]});
        
        ls.sort(Comparator.comparingInt(k -> k[0]));

        for (int i = 0; i < m; i++)
            qs.add(new int[] {queries[i], i});

        qs.sort(Comparator.comparingInt(k -> k[0]));

        int[] freq = new int[n + 1];
        int[] res = new int[m];
        int l = 0, r = 0, serversActive = 0;

        for (int[] q : qs) {
            int t1 = q[0] - x, t2 = q[0];

            while (r < ls.size() && ls.get(r)[0] <= t2) {
                if (freq[ls.get(r)[1]]++ == 0) serversActive++;
                r++;
            }

            while (l < r && ls.get(l)[0] < t1) {
                if (--freq[ls.get(l)[1]] == 0) serversActive--;
                l++;
            }

            res[q[1]] = n - serversActive;
        }

        return res;
    }
}