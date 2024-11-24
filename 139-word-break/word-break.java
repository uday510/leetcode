class Solution {
    Set<String> dictonary;
    Map<Integer, Boolean> seen;
    public boolean wordBreak(String s, List<String> wordDict) {
        intialize(wordDict);

        return dfs(0, s);
    }
    private boolean dfs(int startIdx, String string) {
        if (startIdx >= string.length()) {
            return true;
        }

        if (seen.containsKey(startIdx)) {
            return seen.get(startIdx);
        }

        for (int endIdx = startIdx; endIdx < string.length(); ++endIdx) {
            String substr = string.substring(startIdx, endIdx + 1);

            if (dictonary.contains(substr)) {
                boolean segmented = dfs(endIdx + 1, string);
                if (segmented) {
                    return true;
                }

                seen.put(startIdx, false);
            }
        }

        seen.put(startIdx, false);
        return false;
    }
    private void intialize(List<String> wordDict) {
        dictonary = new HashSet<>(wordDict);
        seen = new HashMap<>();
    }
}