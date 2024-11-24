class Solution {
    static Set<String> set;
    static Map<String, Boolean> seen;
    public boolean wordBreak(String s, List<String> wordDict) {
        set = new HashSet<>();
        seen = new HashMap<>();
        
        for (String str : wordDict) 
            set.add(str);
        
        return dfs(0, "", s);
    }
    public boolean dfs(int i, String curr, String str) {
        if (i == str.length()) 
            return true;
        
        String key = i + "";
        if (seen.containsKey(key))
            return seen.get(key);
        
        for (int j = i; j < str.length(); ++j) {
            String substr = str.substring(i, j + 1);
        
            if (set.contains(substr) && dfs(j+1, curr + substr, str)) {
                seen.put(key, true);
                return true;
            } 
        }
        
        seen.put(key, false);
        return false;
    }
}

