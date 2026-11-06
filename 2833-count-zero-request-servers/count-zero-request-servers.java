class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] qs) {
        int m = qs.length;
        List<int[]> lts = new ArrayList<>();

        for (int[] l : logs) {
            lts.add(new int[] {l[1], l[0]});
        }
        
        lts.sort(Comparator.comparingInt(k -> k[0]));

        List<int[]> qts = new ArrayList<>();
        for (int i = 0; i < qs.length; i++) {
            qts.add(new int[] {qs[i], i});
        }

        qts.sort(Comparator.comparingInt(k -> k[0]));

        int[] freq = new int[n + 1];
        int[] res = new int[m];
        int active = 0, l = 0, r = 0;
        
        for (int[] q : qts) {
            int t1 = q[0] - x, t2 = q[0];

            while (r < lts.size() && lts.get(r)[0] <= t2) {
                if (freq[lts.get(r)[1]]++ == 0) active++;
                r++;
            }

            while (l < r && lts.get(l)[0] < t1) {
                if (--freq[lts.get(l)[1]] == 0) active--;
                l++;
            }

            res[q[1]] = n - active;
        }

        return res;
    }
}

/**


1. Sort the logs by time, and sort the queries by value while keeping their original indices.
2. Use two pointers l and r over the logs, plus freq[serverId] and active (the number of servers with freq > 0).
3. For each query q: move r forward while log[r].time <= q, adding to freq. Then move l forward while log[l].time < q - x, removing from freq.
4. The answer for that query is n - active.


logs: [ [1,3], [1,5], [2,6] ]

1: 2
2: 1
3: 0

qs: [ {5:1}, {5:2}, {6:1}, {6:2} ]

 
 */