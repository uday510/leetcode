class Solution {
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        
      for (int i = 0; i <= nums.length; ++i) {
          int cnt = 0;
          for (int j = 0; j < nums.length; ++j) {
    
              if (nums[j] >= i)
                  cnt++;
          }
          if (cnt == i) return i;
      }
        return -1;
    }
}