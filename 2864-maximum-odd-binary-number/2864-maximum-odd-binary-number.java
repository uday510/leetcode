class Solution {
    public String maximumOddBinaryNumber(String s) {
       char cnt = 0;
       int n = s.length();

       for (int i = 0; i < n; ++i) {
           char c = s.charAt(i);
           if (c == '1') cnt++;
       }
    
       n -= cnt;
       StringBuilder sb = new StringBuilder();
       
       while (cnt-- > 1) sb.append('1');

       while (n-- > cnt) sb.append('0');

       sb.append('1');

       return sb.toString();
    }
}