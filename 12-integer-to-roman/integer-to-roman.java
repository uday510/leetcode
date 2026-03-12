class Solution {

    private static final String[] r = {
        "M", "CM", "D", "CD", "C", "XC", "L",
        "XL", "X", "IX", "V", "IV", "I"
    };

    private static final int[] in = {
        1000, 900, 500, 400, 100, 90,
        50, 40, 10, 9, 5, 4, 1
    };

    private static final int n = r.length;

    public String intToRoman(int num) {

        StringBuilder sb = new StringBuilder();
        int cur = num;

        for (int i = 0; i < n && cur > 0; i++) {

            while (in[i] <= cur) {
                cur -= in[i];
                sb.append(r[i]);
            }
        }

        return sb.toString();    
    }
}