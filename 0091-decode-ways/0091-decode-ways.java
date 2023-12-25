class Solution {
    Map<Integer, Integer> dp = new HashMap<>();
    public int numDecodings(String s) {
        return helper(s, 0);
    }
    public int helper(String s, int index) {
        if (index >= s.length()) {
            return 1;
        }
        
        if (s.charAt(index) == '0') {
            return 0;
        }
        
        if (index == s.length()-1) {
            return 1;
        }
        
        if(dp.containsKey(index)) {
            return dp.get(index);
        }
        
        int res = helper(s, index+1);
        if (Integer.parseInt(s.substring(index, index+2)) <= 26) {
            res += helper(s, index+2);
        }
        
        dp.put(index, res);
        return res;
    }
}