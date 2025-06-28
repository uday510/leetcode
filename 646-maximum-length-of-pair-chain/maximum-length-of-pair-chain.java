class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (p1, p2) -> p1[1] - p2[1]);
        int[] prev = pairs[0];
        int cnt = 1;

        for (int[] pair : pairs) {
            if (prev[1] < pair[0]) {
                prev = pair;
                cnt += 1;
            }
        }

        return cnt;
    }
}