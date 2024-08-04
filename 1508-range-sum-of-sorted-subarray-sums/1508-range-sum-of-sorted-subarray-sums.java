class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        List<Integer> list = new ArrayList<>();
        
        for (int i = 0; i < n; ++i) {
            int curr = 0;
            for (int j = i; j < n; ++j) {
                curr += nums[j];
                list.add(curr);
            }
        }
        Collections.sort(list);
        
        int MOD = (int) 1e9+7;
        int sum = 0;
        
        for (; left <= right; ++left) {
            sum += list.get(left-1);
            sum %= MOD;
        }
        
        return sum;
    }
}