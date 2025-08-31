class Solution {
    public int maximumWealth(int[][] accounts) {
        int max = 0;

        for (int[] a : accounts) {

            int curr = 0;
            for (int m : a) curr += m;

            max = Math.max(max, curr);
        }

        return max;
    }
}