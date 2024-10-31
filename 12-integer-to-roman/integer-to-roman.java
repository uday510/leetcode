class Solution {
    public String intToRoman(int num) {
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] integers = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        StringBuilder sb = new StringBuilder();
        int N = romans.length;
        int curr = num;

        for (int idx = 0; idx < N && curr > 0; ++idx) {
            while (integers[idx] <= curr) {
                sb.append(romans[idx]);
                curr -= integers[idx];
            }
        } 
        return sb.toString();
    }
}