class Solution {

    private static final String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    private static final int[] ints = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static final int n = romans.length;

    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        int cur = num;

        for (int i = 0; i < n && cur > 0; i++) {

            while (ints[i] <= cur) {
                cur -= ints[i];
                sb.append(romans[i]);
            }
        }

        return sb.toString();
    }
}