class Solution {
    public int minimumCost(int[] c) {
        Arrays.sort(c);

        int mn = 0;

        for (int i = c.length - 1; i > -1;) {
            mn += c[i] + (i - 1 > -1 ? c[i - 1] : 0);
            i -= 3;
        }

        return mn;
    }
}