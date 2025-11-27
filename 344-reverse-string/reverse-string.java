class Solution {
    public void reverseString(char[] s) {
        int l = 0, r = s.length - 1;

        while (l < r) swap(l++, r--, s);
    }

    private void swap(int i, int j, char[] s) {
        char tmp = s[i];
        s[i] = s[j];
        s[j] = tmp;
    }
}

/**

     l        r 
["o","e","l","l","h"]


 */
