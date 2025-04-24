class Solution {
    public int firstMissingPositive(int[] nums) {
       Set<Integer> seen = new HashSet<>();


       for (int num : nums) seen.add(num);


       for (int i = 1; i <= nums.length; ++i) {
            if (!seen.contains(i)) return i;
       } 

       return nums.length + 1;
    }
}