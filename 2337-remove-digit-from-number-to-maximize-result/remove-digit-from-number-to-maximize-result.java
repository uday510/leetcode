class Solution {
    public String removeDigit(String number, char digit) {
        String str = "";
        int len = number.length();

        for (int idx = 0; idx < len; ++idx) {
            if (number.charAt(idx) != digit) continue;

            String curr = number.substring(0, idx) + number.substring(idx + 1, len);

            if (curr.compareTo(str) > 0) {
                str = curr;
            }
        }

        return str;
    }
}