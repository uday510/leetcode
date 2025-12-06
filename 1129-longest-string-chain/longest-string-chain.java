class Solution {

    Set<String> validWords;
    Map<String, Integer> dp;
    int n;

    public int longestStrChain(String[] words) {
        intialize(words);

        int longest = 0;
        for (String s : words) {
            int curLen = dfs(s);
            longest = Math.max(curLen, longest);
        }

        return longest;
    }

    private int dfs(String s) {

        if (dp.containsKey(s)) {
            System.out.println("CACHED");
            return dp.get(s);
        }
        
        int curLen = 1;

        for (int i = 0; i < s.length(); i++) {
            String substr = s.substring(0, i) + s.substring(i + 1);

            if (validWords.contains(substr)) {
                curLen = Math.max(curLen, dfs(substr) + 1);
            }
        }

        dp.put(s, curLen);
        
        return curLen;
    }

    private void intialize(String[] words) {
        validWords = new HashSet<>();
        n = words.length;
        dp = new HashMap<>();

        for (int i = 0; i < n; i++) {
            validWords.add(words[i]);
        }

    }
}