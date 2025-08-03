public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int l = 1;
        int r = n;

        while (l < r) {
            int m = (l + r) >>> 1;
            if (guess(m) == 1) l = m + 1;
            else r = m;
        }

        return l;
    }
}