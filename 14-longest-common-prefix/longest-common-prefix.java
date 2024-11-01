class Solution {
    public String longestCommonPrefix(String[] strs) {
        int longest = 0;
        String ans = "";

        for (int idx = 0; idx < strs[0].length(); ++idx) {
            String str = strs[0].substring(0, idx+1);
            if (valid(str, strs)) {
                if (str.length() > longest) {
                    ans = str;
                    longest = str.length();
                }
            }
                
        }
        return ans;
    }
    private boolean valid(String substr, String[] strs) {

        for (String str : strs) {
            if (!str.startsWith(substr)) 
                return false;
        }
        return true;
    }
}