class Solution {
    private static final int[] nums = {
            1000000000, 1000000, 1000, 100, 90, 80,
            70, 60, 50, 40, 30, 20, 19, 18, 17, 16,
            15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5,
            4, 3, 2, 1, 0
    };

    private static final String[] words = {
            "Billion", "Million", "Thousand", "Hundred",
            "Ninety", "Eighty", "Seventy", "Sixty", "Fifty",
            "Forty", "Thirty", "Twenty", "Nineteen", "Eighteen",
            "Seventeen", "Sixteen", "Fifteen", "Fourteen", "Thirteen",
            "Twelve", "Eleven", "Ten", "Nine", "Eight", "Seven",
            "Six", "Five", "Four", "Three", "Two", "One", "Zero"
    };

    public String numberToWords(int cur) {
        if (cur == 0) return words[words.length - 1];

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length && cur > 0; i++) {
            if (cur >= nums[i]) {
                if (nums[i] < 100) {
                    cur -= nums[i];
                    sb.append(words[i]).append(" ");
                } else {
                    sb.append(numberToWords(cur / nums[i])).append(" ").append(words[i]).append(" ");
                    cur %= nums[i];
                }
            }
        }
        
        return sb.toString().trim();
    }
}