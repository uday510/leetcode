class Solution {
    public int lengthOfLastWord(String s) {
        int pointer = s.length() - 1;
        
        while (pointer > -1 && s.charAt(pointer) == ' ') 
                --pointer;
        
        int lastWordLength = 0;
        
        while (pointer > -1 && s.charAt(pointer--) != ' ')
               ++lastWordLength;
        
        return lastWordLength;
    }
}