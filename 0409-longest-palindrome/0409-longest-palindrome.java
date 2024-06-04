class Solution {
    public int longestPalindrome(String s) {
        int res = 0;
        int[] counts = new int[128];
        for(int i = 0; i < s.length(); i++) {
            counts[s.charAt(i)]++;
        }
        boolean single = false;
        for(int count: counts) {
            if(count % 2 == 0) {
                res += count;
            } else {
                res += (count - 1);
                if(!single) {
                    single = true;
                }
            }
            
        }

        return res + (single ? 1: 0);
        
    }
}