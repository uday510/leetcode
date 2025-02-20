class Solution {
    public String findDifferentBinaryString(String[] nums) {
        int len = nums.length;
        char[] arr = new char[len];

        for (int idx = 0; idx < len; ++idx) {
            char ch = nums[idx].charAt(idx);
            arr[idx] = ch == '0' ? '1' : '0';
        }

        return new String(arr);
    }
}