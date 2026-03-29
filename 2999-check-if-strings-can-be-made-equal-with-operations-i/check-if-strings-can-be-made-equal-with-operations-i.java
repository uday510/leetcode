class Solution {
    public boolean canBeEqual(String s1, String s2) {
        char[] ch = s2.toCharArray();

        for (int i = 0; i < 4; ++i) {
            
            if (ch[i] == s1.charAt(i)) { continue; }
            
            if (i + 2 < 4 && ch[i + 2] == s1.charAt(i)) {
                char c = ch[i + 2];
                ch[i + 2] = ch[i];
                ch[i] = c;
            } else {
                return false;
            }
            
        }

        return true;
    }
}