class Solution {

    private List<Integer> lis;

    public int maxEnvelopes(int[][] E) {

        lis = new ArrayList<>();

        Arrays.sort(E, (o1, o2) -> {
            return o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0];
        });  

        for (int i = 0; i < E.length; i++) {
            int num = E[i][1];
            int index = bs(num);
            if (index == lis.size()) lis.add(num);
            lis.set(index, num);
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

/**


[2, 3] [5, 4] [6, 7] [6, 4]

[3, 4, 7]
 */