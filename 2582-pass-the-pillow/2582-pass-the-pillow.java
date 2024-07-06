class Solution {
    public int passThePillow(int n, int time) {
        int curr = 1;
        int pass = 1;
        while (time > 0) {
            
            if (curr == n) {
                pass = -1;
            } else if (curr == 1) {
                pass = 1;
            }
            
            curr += pass;
            --time;
        }
        
        return curr;
    }
}