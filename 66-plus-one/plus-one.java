class Solution {
    public int[] plusOne(int[] digits) {
        
        for (int idx = digits.length - 1; idx > -1; --idx) {
            if (digits[idx] == 9) {
                digits[idx] = 0;
            } else {
                ++digits[idx];

                return digits;
            }
        }

        int[] result = new int[digits.length + 1];

        result[0] = 1;
        

        return result;
    }
}