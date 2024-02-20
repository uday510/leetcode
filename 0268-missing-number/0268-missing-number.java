class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int total = n * (n+1)/2 ;
        
        int sum = Arrays.stream(nums).sum();
        
        return total - sum;
    }
}