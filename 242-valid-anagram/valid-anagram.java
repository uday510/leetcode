class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] counter = new int[128];

        for (int i = 0; i < s.length(); ++i) {
            ++counter[s.charAt(i)];
            --counter[t.charAt(i)];
        }

        for (int count : counter) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }
}