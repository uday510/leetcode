class Solution {
    public String makeFancyString(String s) {
        
        var ans = new StringBuilder();

        for (int i = 0; i < s.length();) {
            int j = i;
            while (j < s.length() && s.charAt(j) == s.charAt(i)) {
                if(j-i+1 < 3) 
                    ans.append(s.charAt(j));
                ++j;
            }
            i = j;
        }
        return ans.toString();
    }
}