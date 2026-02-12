class Solution {
    public int longestBalanced(String s) {
        

        int n = s.length();
        int longest = 0;

        for (int i = 0; i < n; i++) {
            Map<Character, Integer> map = new HashMap<>();

            for (int j = i; j < n; j++) {
                char c = s.charAt(j);
                map.put(c, map.getOrDefault(c, 0) + 1);
                int len = j - i + 1;
                if (map.size() == len || map.get(c) == len) {
                    longest = Math.max(longest, len);
                } else {
                    int req = map.get(c);
                    boolean flag = true;
                    for (Map.Entry<Character, Integer> es : map.entrySet()) {
                        int k = es.getKey(), v = es.getValue();
                        if (v != req) {
                            flag = false;
                            break;
                        }
                    }   

                    if (flag) longest = Math.max(longest, len);
                }

            }
        }

        return longest;
    }
}