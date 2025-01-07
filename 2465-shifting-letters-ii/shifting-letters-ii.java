class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        int[] delta = new int[n + 1];

        for (int[] shift : shifts) {
            int start = shift[0];
            int end = shift[1];
            int direction = shift[2] == 1 ? 1 : -1;

            delta[start] += direction;
            delta[end + 1] -= direction;
        }

        for (int idx = 1; idx < n; ++idx) {
            delta[idx] += delta[idx - 1];
        }

        StringBuilder result = new StringBuilder();
        for (int idx = 0; idx < n; ++idx) {
            char originalChar = s.charAt(idx);
            int newCharVal = (originalChar - 'a' + delta[idx]) % 26;

            if (newCharVal < 0) {
                newCharVal += 26;
            } 

            result.append((char)('a' + newCharVal));
        }

        return result.toString();
    }
}

