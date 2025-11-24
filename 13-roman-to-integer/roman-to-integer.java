class Solution {

    private static Map<String, Integer> vals = new HashMap<>();

    static {
        vals.put("I", 1);
        vals.put("V", 5);
        vals.put("X", 10);
        vals.put("L", 50);
        vals.put("C", 100);
        vals.put("D", 500);
        vals.put("M", 1000);
        vals.put("IV", 4);
        vals.put("IX", 9);
        vals.put("XL", 40);
        vals.put("XC", 90);
        vals.put("CD", 400);
        vals.put("CM", 900);
    }

    public int romanToInt(String s) {
        int res = 0, idx = 0, n = s.length();

        while (idx < n) {

            if (idx < n - 1) {
                String doubleStr = s.substring(idx, idx + 2);

                if (vals.containsKey(doubleStr)) {
                    res += vals.get(doubleStr);
                    idx += 2;
                    continue;
                }

            }

            String single = s.substring(idx, idx + 1);
            res += vals.get(single);
            idx += 1;
        }

        return res;
    }

}