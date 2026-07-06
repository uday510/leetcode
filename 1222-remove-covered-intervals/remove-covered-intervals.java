class Solution {
    public int removeCoveredIntervals(int[][] ints) {
        
        Arrays.sort(ints, (o1, o2) -> {
            if (o1[0] == o2[0])
                return o2[1] - o1[1];
            return o1[0] - o2[0];
        });

        int[] p = ints[0];
        int cnt = ints.length;
        for (int i = 1; i < ints.length; i++) {
            int[] c = ints[i];

            if (c[1] <= p[1]) 
                cnt--;
            else 
                p = c;
        }

        return cnt;
    }
}



/**


[1, 4] [2, 8] [3, 6]


*/