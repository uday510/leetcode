class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> duplicates = new ArrayList<>();
        
        for (int num : nums) {
            int val = Math.abs(num);
            
            if (nums[val-1] < 0) {
                duplicates.add(Math.abs(num));
            }
            nums[val-1] *= -1;
        }
        
        return duplicates;
    }
}