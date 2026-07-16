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

        boolean found = false;
        while (!queue.isEmpty() && !found) {
            int sz = queue.size();

            Set<String> tmp = new HashSet<>();
            for (int i = 0; i < sz; i++) {
                String s = Objects.requireNonNull(queue.poll());
                char[] chars = s.toCharArray();

                for (int j = 0; j < chars.length; j++) {
                    char old = chars[j];

                    for (char c = 'a'; c <= 'z'; c++) {
                        if (old == c)
                            continue;

                        chars[j] = c;
                        String str = new String(chars);
                        if (!validWords.contains(str))
                            continue;

                        adj.computeIfAbsent(str, _ -> new ArrayList<>()).add(s);

                        if (tmp.contains(str)) continue;
                        tmp.add(str);
                        queue.offer(str);
                        if (str.equals(endWord)) found = true;

                    }
                    chars[j] = old;
                }
            }

            validWords.removeAll(tmp);
        }

        if (!found)
            return res;
        
        dfs(endWord, beginWord, adj, new ArrayList<>(List.of(endWord)), res);
        
        return res;
    }
    
    private void dfs(String u, String end, Map<String, List<String>> adj, List<String> path, List<List<String>> res) {
        
        if (u.equals(end)) {
            res.add(new ArrayList<>(path).reversed());
            return;
        }
        
        for (String v : adj.get(u)) {
            path.add(v);
            dfs(v, end, adj, path, res);
            path.removeLast();
        }

    }
}