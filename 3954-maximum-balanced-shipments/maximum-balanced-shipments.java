class Solution {
    public int maxBalancedShipments(int[] weight) {

        int n = weight.length;
        int cnt = 0;
        
        for (int i = 0; i < weight.length; ++i) {
            int j = i + 1;
            while (j < n && weight[j] >= weight[j - 1]) j++;

            int len = j - i + 1;
            if (j == n) return cnt;

            cnt += len > 1 && weight[j] < weight[j - 1] ? 1 : 0;

            i = j;
        }

        return cnt;
    }
}