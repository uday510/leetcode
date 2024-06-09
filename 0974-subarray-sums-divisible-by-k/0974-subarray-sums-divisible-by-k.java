class Solution {
    public int subarraysDivByK(int[] nums, int k) {
           int res = 0;
        // for (int i = 0; i < nums.length; i++) {
        //     int currentSum = 0;
        //     for (int j = i; j < nums.length; j++) {
        //         currentSum += nums[j];
        //         if (currentSum % k == 0) res++;
        //     }
        // }
        // return res;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(0, 1);
        // long res = 0;
        int sum = 0;
        //   rem = 0;
        
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int rem = sum % k;
            if (rem < 0) rem += k;

            if (hashMap.containsKey(rem)) {
                res += hashMap.get(rem);
            }
                hashMap.put(rem , hashMap.getOrDefault(rem, 0) + 1);
            }
        return res;
        
    }
}