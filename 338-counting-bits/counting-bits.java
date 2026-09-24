class Solution {
    public int[] countBits(int n) {
        
        int[] res = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            int bits = getCount(i);
            res[i] = bits;
        }

        return res;
    }

    private int getCount(int n) {
        int bits = 0, mask = 1;
        for (int i = 0; i < 32; i++) {
            if ( (n & mask) != 0) {
                bits++;
            }
            mask <<= 1;
        }
        return bits;
    }
}