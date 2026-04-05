/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int l = 0, r = n;

        while (l < r) {
            int m = ( l + ((r - l) >> 1));

            if (guess(m) == 1) l = m + 1;
            else r = m;
        }

        return l;
    }
}