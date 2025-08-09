class Solution {
    public int maxBalancedShipments(int[] weight) {
        int n = weight.length;
        int cnt = 0;

        for (int i = 0; i < weight.length - 1; ++i) {
            if (weight[i] > weight[i + 1]) {
                cnt++;
                i++;
            }
        }

        return cnt;
    }
}