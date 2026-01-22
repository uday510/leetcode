class Solution {


    Set<String> validWords;
    Map<String, Integer> dp;

    public int longestStrChain(String[] strs) {

        validWords = new HashSet<>();
        dp = new HashMap<>();

        for (String w : strs) {
            validWords.add(w);
        }

        int longest = 1;

        for (String s : strs) {
            longest = Math.max(longest, dfs(s));
        }

        return longest;
    }

    private int dfs(String s) {

        if (dp.containsKey(s)) {
            return dp.get(s);
        }

        int cur = 1;
        for (int i = 0; i < s.length(); i++) {
            String sub = s.substring(0, i) + s.substring(i + 1);

            if (validWords.contains(sub)) {
                cur = Math.max(cur, 1 + dfs(sub));
            }
        }

        dp.put(s, cur);

        return cur;
    }
}