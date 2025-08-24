class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (o1, o2) -> o1[1] - o2[1]);

        int min = -(int) 1e9;
        int cnt = 0;

        for (int[] p : pairs) {

            if (min < p[0]) {
                min = p[1];
                cnt++;
            }
        }

        return cnt;
    }
}