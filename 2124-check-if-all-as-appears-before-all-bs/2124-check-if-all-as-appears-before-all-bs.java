class Solution {
    public boolean checkString(String s) {
        int cnt = 0;
        
        for (char c : s.toCharArray()) {
            if (c == 'a')
                ++cnt;
        }
        
        for (char c : s.toCharArray()) {
            if (c == 'a') 
                --cnt;
            if (c == 'b' && cnt != 0)
                return false;
        }
        
        return cnt == 0;
    }
}