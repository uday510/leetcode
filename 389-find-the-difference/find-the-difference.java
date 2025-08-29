class Solution {
    public char findTheDifference(String s, String t) {
        char ch = getXor(s, (char) 0);
        ch = getXor(t, ch);

        return ch;
    }
    private char getXor(String s, char ch) {
        for (int i = 0; i < s.length(); ++i) {
            ch ^= s.charAt(i);
        }

        return ch;
    }
}

/**


    0 ^ 0 = 0
    0 ^ 1 = 1
    1 ^ 0 = 1
    1 ^ 1 = 0


 */