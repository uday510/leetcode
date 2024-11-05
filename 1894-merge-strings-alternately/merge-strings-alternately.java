class Solution {
    public String mergeAlternately(String word1, String word2) {
        var res = new StringBuilder();
        int i,j,m,n;
        i = j = 0;
        m = word1.length();
        n = word2.length();

        while (i < m && j < n) {
            res.append(word1.charAt(i++));
            res.append(word2.charAt(j++));
        }
        
        res.append(word1.substring(i, m));
        res.append(word2.substring(j, n));

        return res.toString();
    }
}