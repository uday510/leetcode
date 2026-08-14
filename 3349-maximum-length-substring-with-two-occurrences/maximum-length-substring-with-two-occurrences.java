class Solution {
    public int maximumLengthSubstring(String s) {
        Map<Character, Integer> cnts = new HashMap<>();
        int mx = 1, k = 2;

        for (int l = 0, r = 0; r < s.length(); r++) {

            cnts.merge(s.charAt(r), 1, Integer::sum);
            while (l < r && cnts.get(s.charAt(r)) > k) {
                cnts.merge(s.charAt(l++), -1, Integer::sum);
            }

            mx = Math.max(mx, r - l + 1);
        }

        return mx;
    }
}