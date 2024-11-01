class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
       var ans = new ArrayList<Integer>();
        int N = s.length();
        int window = words[0].length();
        int total = words.length * window;
        
        var map = new java.util.HashMap<String, Integer>();
        
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        
        for (int i = 0; i < window; i++) {
            int left = i;
            int right = i;
            int count = 0;
            var tempMap = new java.util.HashMap<String, Integer>();
            
            while (right + window <= N) {
                String word = s.substring(right, right + window);
                right += window;
                
                if (!map.containsKey(word)) {
                    count = 0;
                    left = right;
                    tempMap.clear();
                } else {
                    tempMap.put(word, tempMap.getOrDefault(word, 0) + 1);
                    count++;
                    
                    while (tempMap.getOrDefault(word, 0) > map.getOrDefault(word, 0)) {
                        String leftWord = s.substring(left, left + window);
                        tempMap.put(leftWord, tempMap.get(leftWord) - 1);
                        count--;
                        left += window;
                    }
                    
                    if (count == words.length) {
                        ans.add(left);
                    }
                }
            }
        }
        
        return ans;
    }
}