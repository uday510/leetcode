class Solution {
    Set<String> set;
    public int maxUniqueSplit(String s) {
        set = new HashSet<>();
        return backtrack(s, 0);
    }
    private int backtrack(String s, int start) {
        if (start == s.length()) {
            return 0;
        }

        int max = 0;

        for (int end = start; end < s.length(); ++end) {
            String substring = s.substring(start, end+1);

            if (!set.contains(substring)) {
                set.add(substring);
                max = Math.max(max, 1 + backtrack(s, end+1));
                set.remove(substring);
            }
        }
        return max;
    }
}