class Solution {
    public int maxBalancedShipments(int[] weight) {

        int n = weight.length;
        int cnt = 0;
        
        for (int i = 0; i < weight.length; ++i) {
            int j = i + 1;
            // List<Integer> list = new ArrayList<>();
            // list.add(weight[i]);

            while (j < n && weight[j] >= weight[j - 1]) {
                j++;
            }

            int size = (j - i + 1);
            cnt += size > 1 && j < n && weight[j] < weight[j - 1] ? 1 : 0;
            i = j;
        }

        return cnt;
    }
}