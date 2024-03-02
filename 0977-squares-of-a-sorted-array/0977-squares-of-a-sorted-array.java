class Solution {
    public int[] sortedSquares(int[] nums) {
        
        int n = nums.length;
        int[] res = new int[n];
        
        int i = 0;
        int j = n - 1;
        int idx = n-1;
        
        while (idx > -1) {
            int num1 = Math.abs(nums[i]);
            int num2 = Math.abs(nums[j]);
            
            if (num1 < num2) {
                res[idx--] = num2 * num2;
                j--;
            } else {
                res[idx--] = num1 * num1;
                i++;
            }
        }
        return res;
    }
}