class Solution {
    public String findDifferentBinaryString(String[] nums) {
        
        StringBuilder sb = new StringBuilder();

        for (int idx = 0; idx < nums.length; idx++) {
            char cur = nums[idx].charAt(idx) == '0' ? '1' : '0';

            sb.append(cur);
        }

        return sb.toString();
    }
}