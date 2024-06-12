class Solution {
    public boolean sumOfNumberAndReverse(int num) {
    
        int curr = num;
        
        for (int i = 0; i <= num ; ++i) {
            
            if (valid(i, num)) {
                return true;
            }
        }
        
        return false;
    }
    public boolean valid(int num, int actual) {
        
        int curr = num;
        
        int val = 0;
        
        while (curr > 0) {
            val *= 10;
            val += (curr%10);
            curr /= 10;
        }
        
        return val + num == actual;
    }
}