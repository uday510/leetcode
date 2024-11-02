class Solution {
    public boolean isAnagram(String s, String t) {
        int[] cnt = new int[128];

        for (char c : s.toCharArray()) 
            ++cnt[c];
        
        for (char c : t.toCharArray())
            --cnt[c];

        for (int i = 0; i < 128; ++i) 
            if (cnt[i] != 0)
                return false;
            
        return true;
    }
}