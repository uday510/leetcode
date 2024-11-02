class Solution {
    public int[] twoSum(int[] nums, int target) {
        var map = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; ++i) {
                int num = nums[i];
                int rem = target - num;

                if (map.containsKey(rem)) 
                    return new int[]{map.get(rem), i};

                map.put(num, i);
        }
        return new int[]{-1,-1};
    }
}