class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (p1, p2) -> p1[1] - p2[1]);
        int min = - (int) 1e9;
        int cnt = 0;

        for (int[] pair : pairs) {
           if (min < pair[0]) {
             min = pair[1];
             cnt += 1;
           }
        }

        return cnt;
    }
}