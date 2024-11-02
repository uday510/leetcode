class Solution {
    public boolean isCircularSentence(String sentence) {
        String[] s = sentence.split(" ");
        int N = s.length;
        
        for (int i = 0; i < N-1; ++i)
             if (s[i+1].charAt(0) != s[i].charAt(s[i].length()-1))
                return false;

        return s[0].charAt(0) == s[N-1].charAt(s[N-1].length()-1);
    }
}