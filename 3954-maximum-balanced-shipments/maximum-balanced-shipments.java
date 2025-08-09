class Solution {
    public int maxBalancedShipments(int[] weight) {

        int n = weight.length;
        int cnt = 0;
        
        for (int i = 0; i < weight.length; ++i) {
            int j = i + 1;
            List<Integer> list = new ArrayList<>();
            list.add(weight[i]);

            while (j < n && weight[j] >= list.getLast()) {
                list.add(weight[j++]);
            }

            if (j < n) list.add(weight[j]);

            cnt += list.size() > 1 && list.getLast() < list.get(list.size() - 2) ? 1 : 0;
            i = j;
        }

        return cnt;
    }
}