class Solution {
    public List<List<String>> findLadders(String st, String en, List<String> wList) {
        
        List<List<String>> res = new ArrayList<>();

        if (st.equals(en))
            return res;

        Set<String> validWords = new HashSet<>(wList);

        if (!validWords.contains(en))
            return res;
        
        Map<String, List<String>> adj = new HashMap<>();
        Queue<String> queue = new ArrayDeque<>();

        validWords.remove(st);
        queue.offer(st);
        boolean isFound = false;
        while (!queue.isEmpty() && !isFound) {
            int sz = queue.size();
            Set<String> tmp = new HashSet<>();

            for (int i = 0; i < sz; i++) {
                String curStr = queue.poll();
                char[] chars = Objects.requireNonNull(curStr).toCharArray();

                for (int j = 0; j < chars.length; j++) {
                    char prev = chars[j];

                    for (char cur = 'a'; cur <= 'z'; cur++) {
                        if (prev == cur) continue;

                        chars[j] = cur;
                        String newStr = new String(chars);

                        if (!validWords.contains(newStr)) continue;
                        adj.computeIfAbsent(newStr, k -> new ArrayList<>()).add(curStr);

                        if (tmp.contains(newStr)) continue;

                        queue.offer(newStr);
                        tmp.add(newStr);
                        if (newStr.equals(en)) 
                            isFound = true;
                    }

                    chars[j] = prev;
                }
            }

            validWords.removeAll(tmp);
        }

        if (!isFound) return res;

        dfs(en, st, new ArrayList<>(List.of(en)), adj, res);

        return res;
    }

    private void dfs(String str, String en, 
                    List<String> curList,
                    Map<String, List<String>> adj,
                    List<List<String>> res
                    ) {

                        if (str.equals(en)) {
                            res.add(new ArrayList<>(curList).reversed());
                            return;
                        }

                        for (String nxt : adj.get(str)) {
                            curList.add(nxt);
                            dfs(nxt, en, curList, adj, res);
                            curList.removeLast();
                        }
                    }
}