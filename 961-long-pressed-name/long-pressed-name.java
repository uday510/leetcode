class Solution {
    public boolean isLongPressedName(String name, String typed) {
        if (typed.length() < name.length()) return false;
        
        int idx1 = 0;
        int idx2 = 0;
        
        while (idx1 < name.length() && idx2 < typed.length()) {
            
            int index = idx1;
            char ch1 = name.charAt(idx1);

            while (index < name.length() && name.charAt(idx1) == name.charAt(index)) {
                index++;
            }
            
            int count1 = index - idx1;
            idx1 = index;
                        
            char ch2 = typed.charAt(idx2);
            
            // if (ch1 != ch2) return false;
                                
            int index2 = idx2;
                
            while (index2 < typed.length() && ch1 == typed.charAt(index2)) {
                index2++;
            }
                
                int count2 = index2 - idx2;
                idx2 = index2;
                
                if (count2 < count1) {
                    return false;
                }
        }
        
        return idx1 == name.length() && idx2 == typed.length();
    }
}

