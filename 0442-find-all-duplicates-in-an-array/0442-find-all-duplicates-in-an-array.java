class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> duplicates = new ArrayList<>();
        
        for (int num : nums) {
            int val = Math.abs(num) - 1;
            
            if (nums[val] < 0) {
                duplicates.add(Math.abs(num));
            }
            nums[val] *= -1;
        }
        
        return duplicates;
    }
}