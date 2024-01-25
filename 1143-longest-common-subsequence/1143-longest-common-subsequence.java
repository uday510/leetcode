class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[] prev = new int[m+1];
        
        for (int i = n-1; i >= 0; --i) {
            int[] curr = new int[m+1];
            for (int j = m-1; j >= 0; --j) {
                char c1 = text1.charAt(i);
                char c2 = text2.charAt(j);
                
                if (c1 == c2) {
                     curr[j] = 1 + prev[j+1];
                } else {
                    curr[j] = Math.max(prev[j], curr[j+1]);
                }
            }
            prev = curr;
        }
        return prev[0];
    }
}