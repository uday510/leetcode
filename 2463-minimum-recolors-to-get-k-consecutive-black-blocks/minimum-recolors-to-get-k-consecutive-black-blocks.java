class Solution {
    char WHITE = 'W';
    public int minimumRecolors(String s, int k) {
        int min = 0;
        int cnt = 0;

        for (int idx = 0; idx < k; ++idx) {
            if (s.charAt(idx) == WHITE) {
                cnt++;
            }
        }

        if (cnt == 0) return 0;
        min = cnt;

        for (int idx = k; idx < s.length(); ++idx) {
            if (s.charAt(idx-k) == WHITE) {
                cnt--;
            }

            if (s.charAt(idx) == WHITE) {
                cnt++;
            }

            min = Math.min(min, cnt);
        }

        return min;
    }
}


/**

min = 
cnt = 

idx = 2

W B W B B B W

 */