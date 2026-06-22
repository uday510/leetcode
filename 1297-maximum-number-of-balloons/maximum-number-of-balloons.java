class Solution {

    public int maxNumberOfBalloons(String s) {
        return maxNumberOfBalloons(s, "balloon");
    }

    private int maxNumberOfBalloons(String s, String p) {
        int[] sCnt = new int[26];
        int[] pCnt = new int[26];

        for (int i = 0; i < p.length(); i++) {
            pCnt[p.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            sCnt[s.charAt(i) - 'a']++;
        }
    
        int mn = s.length();
        for (int i = 0; i < p.length(); i++) {
            int idx = p.charAt(i) - 'a';

            if (sCnt[idx] == 0) return 0;

            if (pCnt[idx] > 0) {
                mn = Math.min(mn, sCnt[idx] / pCnt[idx]);
            }
        }

        return mn;
    }


}