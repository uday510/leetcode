class Solution {
    public String compressedString(String s) {
        int n = s.length();
        var sb = new StringBuilder();

       for (int i = 0; i < n;) {
            char c = s.charAt(i);

            int j = i;
            while (j < n && s.charAt(j) == c && (j-i+1) < 10) {
                j += 1;
            }
            sb.append(j-i + "" + c);
            i = j;
       }
       return sb.toString();
    }
}