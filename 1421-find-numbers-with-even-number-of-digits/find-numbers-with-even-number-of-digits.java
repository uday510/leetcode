class Solution {
    public int findNumbers(int[] nums) {
        int count = 0;
        for (var num : nums) 
            if ((int)(Math.log10(num)+1) % 2 == 0) count++;
        
        return count;
    }
}