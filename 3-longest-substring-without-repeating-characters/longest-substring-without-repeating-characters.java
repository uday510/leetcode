class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int longest = 0;

        Set<Character> seen;

        for (int i = 0; i < n; i++) {
            seen = new HashSet<>();

            for (int j = i; j < n; j++) {
                char ch = s.charAt(j);
                if (!seen.add(ch)) break;

                longest = Math.max(longest, j - i + 1);

            }
        }

        return longest;
    }
}


/**

abcabcbb


 */