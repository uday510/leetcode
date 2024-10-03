class Solution {
    public int minSubarray(int[] nums, int p) {
        int N = nums.length;
        int total = 0;
        
        for (int num : nums) {
            total = (total + num) % p;
        }
        
        if (total == 0) {
            return 0;
        }
        
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int curr = 0;
        int min = N;
        
        for (int i = 0; i < N; ++i) {
            curr = (curr + nums[i]) % p;
            
            int need = (curr - total + p) % p;
            
            if (map.containsKey(need)) {
                min = Math.min(min, i - map.get(need));
            }
            
            map.put(curr, i);
        }
        
        return min == N ? -1 : min;
    }
}