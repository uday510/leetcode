class Solution {
    public String mergeAlternately(String s1, String s2) {
        StringBuilder sb = new StringBuilder();
        int n = s1.length(), m = s2.length();

        for (int i = 0, j = 0; i < n || j < m;) {

            if (i < n) sb.append(s1.charAt(i++));
            if (j < m) sb.append(s2.charAt(j++));
        }



        return sb.toString();
    }
}