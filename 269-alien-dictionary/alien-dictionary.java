class Solution {
    public String alienOrder(String[] words) {
        
        int n = words.length;
        Map<Character, Set<Character>> adj = new HashMap<>();
        Map<Character, Integer> inorder = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String w = words[i];
            for (int j = 0; j < w.length(); j++) {
                char c = w.charAt(j);
                adj.putIfAbsent(c, new HashSet<>());
                inorder.putIfAbsent(c, 0);
            }
        }

        for (int i = 0; i < n - 1; i++) {
            String w1 = words[i];
            String w2 = words[i + 1];

            
            if (w1.length() > w2.length() && w1.startsWith(w2) )
                return "";
            
            int m = Math.min(w1.length(), w2.length());

            for (int j = 0; j < m; j++) {
                char c1 = w1.charAt(j), c2 = w2.charAt(j);

                if (c1 != c2) {
                   if (!adj.get(c1).contains(c2)) {
                        adj.get(c1).add(c2);
                        inorder.merge(c2, 1, Integer::sum);
                   }
                   break;
                }
            }
        }

        Queue<Character> queue = new ArrayDeque<>();

        for (Map.Entry<Character, Integer> es : inorder.entrySet()) {
            char k = es.getKey();
            Integer v = es.getValue();
            if (v == 0) {
                queue.offer(k);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            char c = queue.poll();
            sb.append(c);

            for (char v : adj.get(c)) {
                if (inorder.merge(v, -1, Integer::sum) == 0) {
                    queue.offer(v);
                }
            }
        }
        
        return sb.length() != inorder.size() ? new String() :  sb.toString();
    }
}