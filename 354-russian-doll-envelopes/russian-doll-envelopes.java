class Solution {

    List<Integer> lis;

    public int maxEnvelopes(int[][] E) {
        lis = new ArrayList<>();

        Arrays.sort(E, (o1, o2) -> {
            if (o1[0] == o2[0]) return o2[1] - o1[1];
            return o1[0] - o2[0];
        });

        for (int i = 0; i < E.length; i++) {
            int num = E[i][1];
            int nxtIdx = bs(num);
            if (nxtIdx == lis.size()) lis.add(num);
            lis.set(nxtIdx, num);
        }

        return lis.size();
    }

    private int bs(int target) {
        int l = 0, r = lis.size();

        while (l < r) {
            int m = (l + r) >> 1;

            if (lis.get(m) < target) l = m + 1;
            else r = m;
        }

        return l;
    }
}