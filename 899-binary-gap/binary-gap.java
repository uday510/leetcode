class Solution {
    public int binaryGap(int n) {

        int cur = n, pos = 0, last = 31, mx = 0;

        while (cur != 0) {

            if ( (cur & 1) != 0) {

                mx = Math.max(mx, pos - last);
                
                last = pos;
            }

            cur >>= 1;
            pos++;
        }

        return mx;
        
    }
}