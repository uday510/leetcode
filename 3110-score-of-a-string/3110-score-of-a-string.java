class Solution {
    public int scoreOfString(String s) {
        int currScore = 0;

        for (int i = 0; i < s.length() - 1; ++i) {
            char currChar = s.charAt(i);
            char nextChar = s.charAt(i+1);

            currScore += Math.abs(currChar - nextChar);
        }
        return currScore;
    }
}