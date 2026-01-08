class Solution {
    public boolean canConstruct(String r, String m) {
        
        int[] cnt = new int[128];

        for (char c : r.toCharArray()) {
            ++cnt[c];
        }

        for (char c : m.toCharArray()) {
            --cnt[c];
        }

        for (char c : r.toCharArray()) {
            if (cnt[c] > 0) return false;
        }

        return true;
    }
}