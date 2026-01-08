class Solution {

    int[] cnt;

    public boolean isAnagram(String s, String t) {

        cnt = new int[128];

        updateCnt(s, 1);
        updateCnt(t, -1);

        for (int i = 97; i < 128; i++) {
            if (cnt[i] != 0) return false;
        }

        return true;
    }

    private void updateCnt(String s, int inc) {

        for (int i = 0; i < s.length(); i++) {
            cnt[s.charAt(i)] += inc;
        }

    }
    
}