class Solution {
    public int findComplement(int num) {
        int n = num;
        int ans = 0;

        for(int bit = 0; n > 0; bit++){
            if(((num >> bit) & 1) == 0){
                ans |= (1 << bit);
            }
            n >>= 1;
        }

        return ans;
    }
}