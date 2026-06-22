class Solution {

    public int maxNumberOfBalloons(String s) {
        return maxNumberOfBalloons(s, "balloon");
    }

    private int maxNumberOfBalloons(String s, String p) {
        int[] sCnt = new int[26];
        int[] pCnt = new int[26];

        inc(pCnt, p);
        inc(sCnt, s);
    
        int mn = s.length();
        for (int i = 0; i < p.length(); i++) {
            int idx = p.charAt(i) - 'a';

            if (sCnt[idx] == 0 || pCnt[idx] == 0) return 0;

            if (pCnt[idx] > 0) {
                mn = Math.min(mn, sCnt[idx] / pCnt[idx]);
            }
        }

        return mn;
    }

    private void inc(int[] arr, String s) {
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
        }
    }

}