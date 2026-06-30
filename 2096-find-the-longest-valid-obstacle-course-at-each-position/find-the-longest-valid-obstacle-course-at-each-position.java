class Solution {
    public int[] longestObstacleCourseAtEachPosition(int[] obs) {
        
        int n = obs.length;
        int[] res = new int[n];

        List<Integer> lis = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            int idx = bs(obs[i], lis);
            res[i] = idx + 1;

            if (idx == lis.size()) lis.add(obs[i]);
            lis.set(idx, obs[i]);
        }

        return res;
    }

    private int bs (int t, List<Integer> list) {

        int l = 0, r = list.size();

        while (l < r) {

            int m = l + ((r - l) >> 1);

            if (list.get(m) <= t) l = m + 1;
            else r = m;
        }

        return l;
    }
}

/**




 */