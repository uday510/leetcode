class Solution {
    static Set<String> set;
    static Map<Integer, Boolean> seen;
    public boolean wordBreak(String s, List<String> wordDict) {
        set = new HashSet<>();
        seen = new HashMap<>();
        
        for (String str : wordDict) 
            set.add(str);
        
        return dfs(0, s);
    }
    public boolean dfs(int index, String str) {
        if (index == str.length()) 
            return true;
        
        if (seen.containsKey(index))
            return seen.get(index);
        
        for (int j = index; j < str.length(); ++j) {
            String substr = str.substring(index, j + 1);
        
            if (set.contains(substr) && dfs(j+1, str)) {
                seen.put(index, true);
                return true;
            } 
        }
        
        seen.put(index, false);
        return false;
    }
}

