class Solution {
    public int lengthOfLastWord(String s) {
        int index = s.length() - 1;
        
        while (index > -1 && s.charAt(index) == ' ') 
                --index;
        
        int lastWordLength = 0;
        
        while (index > -1 && s.charAt(index--) != ' ') 
              ++lastWordLength;
        
        return lastWordLength;
    }
}