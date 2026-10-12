class Solution {
    public int maxEnvelopes(int[][] envs) {
        List<Integer> lis = new ArrayList<>();

        Arrays.sort(envs, (o1, o2) -> {
            if (o1[0] == o2[0]) return o2[1] - o1[1];
            return o1[0] - o2[0];
        });

        for (int[] e : envs) {
            int val = e[1];
            int idx = bs(val, lis);

            if (idx == lis.size()) 
                lis.add(val);
            
            lis.set(idx, val);
        }

        return lis.size();
    }

    private int bs(int t, List<Integer> list) {

        int l = 0, r = list.size();

        while (l < r) {

            int m = l + ( (r - l) >> 1);

            if (list.get(m) < t) l = m + 1;
            else r = m;
        }

        return l;
    }
}