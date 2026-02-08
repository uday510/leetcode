class Solution {
    public int minimumDeletions(String s) {
        int aCnt,bCnt, n, res;
        n = s.length();
        res = n; aCnt = bCnt = 0;
                
        for (int i = 0; i < n; ++i) {
            aCnt += s.charAt(i) == 'a' ? 1 : 0;
        }
        
        for (int i = 0; i < n; ++i) {
            aCnt -= s.charAt(i) == 'a' ? 1 : 0;
                       
            res = Math.min(res, aCnt + bCnt);
            bCnt += s.charAt(i) == 'b' ? 1 : 0;
        }

        return res;

    }
}
