class Solution {
    public int countBinarySubstrings(String s) {
        int n = s.length();
        int cnt = 0;

        for (int j = 1; j < n;) {
            
            int i = j - 1;
            char c1 = s.charAt(i), c2 = s.charAt(j);
            int c1Cnt = 1, c2Cnt = 1;

            if (c1 == c2) j++;
            else {
                while (c1 != c2 && i >= 0 && j < n && c1Cnt == c2Cnt && s.charAt(i) == c1 && s.charAt(j) == c2) {
                    cnt++;
                    c1Cnt++;
                    c2Cnt++;
                    i--;
                    j++;
                }
            } 
        }

        return cnt;
    }
}
