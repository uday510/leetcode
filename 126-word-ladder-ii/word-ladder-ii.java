class Solution {
    public List<List<String>> findLadders(String st, String en, List<String> words) {
        List<List<String>> res = new ArrayList<>();

        if(st.equals(en))
            return res;
        
        Set<String> validWords = new HashSet<>(words);
        Map<String, List<String>> adj = new HashMap<>();
        Queue<String> queue = new ArrayDeque<>();

        validWords.remove(st);
        queue.offer(st);

        boolean isFound = false;
        while (!queue.isEmpty() && !isFound) {
            Set<String> tmp = new HashSet<>();
            int sz = queue.size();

            for (int i = 0; i < sz; i++) {
                String s = queue.poll();
                char[] ch = s.toCharArray();

                for (int j = 0; j < ch.length; j++) {
                    char o = ch[j];

                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == o) continue;

                        ch[j] = c;
                        String cur = new String(ch);

                        if (!validWords.contains(cur)) 
                            continue;
                        
                        adj.computeIfAbsent(cur, k -> new ArrayList<>()).add(s);

                        if (tmp.contains(cur))
                            continue;
                        
                        if (cur.equals(en)) 
                            isFound = true;

                        tmp.add(cur);
                        queue.offer(cur);
                    }

                    ch[j] = o;
                }
            }

            validWords.removeAll(tmp);
        }

        if (!isFound) return res;
        
        dfs(en, st, new ArrayList<>(List.of(en)), adj, res);

        return res;
    }

    private void dfs(String s, String e, List<String> cur, Map<String, List<String>> adj, List<List<String>> res) {

        if (s.equals(e)) {
            res.add(new ArrayList<>(cur).reversed());
            return;
        }

        for (String nxt : adj.get(s)) {
            cur.add(nxt);
            dfs(nxt, e, cur, adj, res);
            cur.removeLast();
        }
    }


}