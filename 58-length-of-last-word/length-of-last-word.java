class Solution {
    public int lengthOfLastWord(String s) {
        int N = s.length();
        int i = N-1;
        int cnt = 0;

        while (i > -1 && s.charAt(i) == ' ') {
             i--;
        }
           

        while (i > -1 && s.charAt(i) != ' ') {
            --i;
            cnt++;
        }
        return cnt;
    }
}