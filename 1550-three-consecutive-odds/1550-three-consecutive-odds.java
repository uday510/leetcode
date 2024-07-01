class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int cnt = 0;
        
        for (int i = 0; i < arr.length && cnt != 3; ++i) {
            int num = arr[i];
            if ((num & 1) == 1) {
                ++cnt;
            } else {
                cnt = 0;
            }
        }
        return cnt == 3;
    }
}