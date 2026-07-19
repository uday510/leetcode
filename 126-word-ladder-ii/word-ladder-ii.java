class Solution {
    public List<List<String>> findLadders(String st, String en, List<String> wordList) {
        
        List<List<String>> res = new ArrayList<>();
        Set<String> validWords = new HashSet<>(wordList);
        
        if (!validWords.contains(en) || st.equals(en))
            return res;

        Map<String, List<String>> adj = new HashMap<>();
        Queue<String> queue = new ArrayDeque<>();
        
        boolean hasFound = false;
        validWords.remove(st);
        queue.offer(st);

        Set<String> tmp = new HashSet<>();
        while (!queue.isEmpty() && !hasFound) {
            int sz = queue.size();

            for (int i = 0; i < sz; i++) {

                String cur = queue.poll();
                char[] chars = cur.toCharArray();

                for (int j = 0; j < chars.length; j++) {
                    char old = chars[j];

                    for (char c = 'a'; c <= 'z'; c++) {
                        if (old == c) continue;

                        chars[j] = c;
                        String str = new String(chars);

                        if (!validWords.contains(str)) continue;
                        adj.computeIfAbsent(str, k -> new ArrayList<>()).add(cur);

                        if (tmp.contains(str)) continue;

                        tmp.add(str);
                        queue.offer(str);

                        if (str.equals(en)) {
                            hasFound = true;
                        }
                    }

                    chars[j] = old;
                }
            }

            validWords.removeAll(tmp);
        }

        
        dfs(en, st, adj, new ArrayList<>(List.of(en)), res);
        return res;
    }

    private void dfs(String u, String en, Map<String, List<String>> adj, List<String> cur, List<List<String>> res) {

        if (u.equals(en)) {
            res.add(new ArrayList<>(cur).reversed());
            return;
        }

        for (String v : adj.getOrDefault(u, new ArrayList<>())) {
            cur.add(v);
            dfs(v, en, adj, cur, res);
            cur.removeLast();
        }


    }
}