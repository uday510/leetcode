class Solution {
    public String longestCommonPrefix(String[] strs) {
       StringBuilder sb = new StringBuilder();

        for (int i = 0; i < strs[0].length(); ++i) {
            char ch = strs[0].charAt(i);
            for (int idx = 1; idx < strs.length; ++idx) {
                if (i >= strs[idx].length() || 
                  (strs[idx].charAt(i) != ch)) return sb.toString();
            }
            
            sb.append(ch);
         }

       return sb.toString(); 
    }
}