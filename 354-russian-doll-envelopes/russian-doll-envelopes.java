class Solution {
    private List<Integer> lis;
    public int maxEnvelopes(int[][] envs) {
        lis = new ArrayList<>();

        Arrays.sort(envs, (o1, o2) -> {
            if (o1[0] == o2[0]) return o2[1] - o1[1];
            return o1[0] - o2[0];
        });

        int n = envs.length;

        for (int i = 0; i < n; i++) {

            int cur = envs[i][1];
            int index = bs(cur);

            if (index == lis.size()) lis.add(cur);
            lis.set(index, cur);
        }

        return lis.size();
    }

    private int bs(int t) {
        int l = 0, r = lis.size();

        while (l < r) {

            int m = l + ( (r - l) >> 1);

            if (lis.get(m) < t) l = m + 1;
            else r = m;
        }


        return l;
    }
}


/***


[1, 1] [2, 3] [4, 6], [4, 5] [6, 7]

[1, 3, 5, 7]




 */