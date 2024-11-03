class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int N = s.length();
        int M = p.length();
        var res = new ArrayList<Integer>();

        for (int i = 0; i < N-M+1; ++i) {
            if (anagram(s.substring(i, i+M), p))
                res.add(i);
        }
        return res;
    }
    boolean anagram(String s, String t) {
        int[] cnt = new int[128];

        for (char c : s.toCharArray()) {
            ++cnt[c];
        }

        for (char c : t.toCharArray()) {
            --cnt[c];
        }

        for (int c : cnt) {
            if (c != 0) 
                return false;
        }
        return true;
    }
}