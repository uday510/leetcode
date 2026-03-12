class Solution {

    private static Map<String, Integer> map = new HashMap<>();
    static {
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put( "M", 1000);

        map.put("IV", 4);
        map.put("IX", 9);
        map.put("XL", 40);
        map.put("XC", 90);
        map.put("CD", 400);
        map.put("CM", 900);
    }

    public int romanToInt(String s) {
        
        int res = 0, idx = 0, n = s.length();

        while (idx < n) {

            if (idx < n - 1) {
                String d = s.substring(idx, idx + 2);

                if (map.containsKey(d)) {
                    res += map.get(d);
                    idx += 2;
                    continue;
                }
            }

            res += map.get(s.substring(idx, idx + 1));

            idx += 1;
        }

        return res;
    }
}