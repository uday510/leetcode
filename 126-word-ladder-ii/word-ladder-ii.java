class Solution {

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        List<List<String>> res = new ArrayList<>();

        if (beginWord.equals(endWord))
            return res;

        Set<String> validWords = new HashSet<>(wordList);

        if (!validWords.contains(endWord))
            return res;

        Map<String, List<String>> adj = new HashMap<>();

        Queue<String> queue = new ArrayDeque<>();

        validWords.remove(beginWord);
        queue.offer(beginWord);

        boolean isFound = false;
        Set<String> tmp = new HashSet<>();
        while (!queue.isEmpty() && !isFound) {
            int sz = queue.size();

            for (int curIdx = 0; curIdx < sz; curIdx++) {
                String str = Objects.requireNonNull(queue.poll());
                char[] chars = str.toCharArray();

                for (int j = 0; j < chars.length; j++) {
                    char oldChar = chars[j];

                    for (char newChar = 'a'; newChar <= 'z'; newChar++) {
                        if (oldChar == newChar) continue;

                        chars[j] = newChar;
                        String newStr = new String(chars);

                        if (!validWords.contains(newStr)) continue;

                        adj.computeIfAbsent(newStr, k -> new ArrayList<>()).add(str);

                        if (tmp.contains(newStr)) continue;

                        tmp.add(newStr);
                        queue.offer(newStr);

                        if (newStr.equals(endWord)) isFound = true;

                    }

                    chars[j] = oldChar;
                }
            }
            
             validWords.removeAll(tmp);
        }

        if (!isFound) 
            return res;
        
        
        dfs(endWord, beginWord, new ArrayList<>(List.of(endWord)), adj, res);
        
        return res;
    }
    
    private void dfs(String u, String end, List<String> curPath, Map<String, List<String>> adj, List<List<String>> res) {
        
        if (u.equals(end)) {
            res.add(new ArrayList<>(curPath).reversed());
            return;
        }
        
        for (String v : adj.getOrDefault(u, new ArrayList<>())) {
            curPath.add(v);
            dfs(v, end, curPath, adj, res);
            curPath.removeLast();
        }
        
    }
}