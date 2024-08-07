class Solution {
    int[] nums = {1_000_000_000, 1_000_000, 1000, 100, 90, 80, 70, 60, 50, 40, 30,
        20, 19, 18, 17, 16, 15, 14, 13,12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
    String[] words = {"Billion", "Million", "Thousand", "Hundred", "Ninety", "Eighty"
        , "Seventy", "Sixty", "Fifty", "Forty", "Thirty", 
        "Twenty", "Nineteen", "Eighteen", "Seventeen", "Sixteen", "Fifteen", 
        "Fourteen", "Thirteen", "Twelve", "Eleven", "Ten",
        "Nine", "Eight", "Seven", "Six", "Five", 
        "Four", "Three", "Two", "One", "Zero"
        };
    public String numberToWords(int num) {
        if (num == 0) {
            return words[nums.length-1]; // Zero
        }

            StringBuilder sb = new StringBuilder();

            int i = 0;
            while (num > 0) {
                if (nums[i] <= num) {
                    if (num < 100) {
                        sb.append(words[i]).append(" ");
                        num -= nums[i];
                    } else {
                        int quotient = num / nums[i];
                        sb.append(numberToWords(quotient))
                        .append(" ").append(words[i]).append(" ");
                        num %= nums[i];
                    }
                }
                ++i;
            }
        return sb.toString().trim();       
    }
}