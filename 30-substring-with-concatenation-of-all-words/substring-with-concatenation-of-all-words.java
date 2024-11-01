class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        int N = s.length();
        int window = words[0].length();
        var ans = new ArrayList<Integer>();
        var map = new HashMap<String, Integer>();

        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);            
        }

        for (int i = 0; i < window; ++i) {
            int left = i;
            int right = i;
            int cnt = 0;
            var tmp = new HashMap<String, Integer>();
            System.out.println(" ---- ");
            while (right + window <= N) {
                String str = s.substring(right, right+window);
                System.out.println(str);
                right += window;

                if (!map.containsKey(str)) {
                    cnt = 0;
                    left = right;
                    tmp.clear();
                } else {
                    tmp.put(str, tmp.getOrDefault(str, 0) + 1);
                    ++cnt;

                    while (tmp.get(str) > map.get(str)) {
                        String leftStr = s.substring(left, left+window);

                        tmp.put(leftStr, tmp.get(leftStr)-1);
                        left += window;
                        --cnt;
                    }

                    if (cnt == words.length) {
                        ans.add(left);
                    }
                }
            }
        }
        return ans;
    }
}