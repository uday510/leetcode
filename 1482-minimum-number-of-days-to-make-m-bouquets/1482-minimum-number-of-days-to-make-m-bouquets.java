class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
         
        if ((long) m * k > n ) return -1;

        int leftIdx = Integer.MAX_VALUE;
        int rightIdx = Integer.MIN_VALUE;

        for (int day : bloomDay) {
            leftIdx = Math.min(day, leftIdx);
            rightIdx = Math.max(day, rightIdx);
        }

        while (leftIdx < rightIdx) {

            int day = (leftIdx + rightIdx) >> 1;

            if (canMakeBouquets(bloomDay, m, k, day)) {
                rightIdx = day;
            } else {
                leftIdx = day + 1;
            }
        }
        return leftIdx;
    }
    public boolean canMakeBouquets(int[] bloomDay, int m, int k, int day) {
            int currAdj = 0;
            int currBouquets = 0;

            for (int i = 0; i < bloomDay.length && currBouquets < m; ++i) {
                int currDay = bloomDay[i];
                if (currDay <= day) {
                    ++currAdj;
                    if (currAdj == k) {
                        ++currBouquets;
                        currAdj = 0;
                    }
                } else {
                    currAdj = 0;
                }
            }
            return currBouquets >= m;
    }
}
