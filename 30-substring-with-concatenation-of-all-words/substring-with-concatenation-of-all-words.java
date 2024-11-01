class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        var ans = new ArrayList<Integer>();
        int N = s.length();
        int window = words[0].length();
        int total = words.length * window;
        var map = new HashMap<String, Integer>();

        for (String word: words) 
            map.put(word, map.getOrDefault(word, 0) + 1);

        for (int i = 0; i < window; ++i) {
            int left = i;
            int right = i;
            int cnt = 0;
            var tmp = new HashMap<String, Integer>();

            while (right + window <= N) {
                String str = s.substring(right, right + window);
                right += window;

                if (!map.containsKey(str)) {
                    cnt = 0;
                    left = right;
                    tmp.clear();
                } else {
                    tmp.put(str, tmp.getOrDefault(str, 0) + 1);
                    ++cnt;

                    while (tmp.get(str) > map.get(str)) {
                        String leftWord = s.substring(left, left+window);
                        tmp.put(leftWord, tmp.get(leftWord)-1);
                        --cnt;
                        left += window;
                    }
                    if (cnt == words.length)
                        ans.add(left);
                }
            }
        }
        return ans;
    }
}
