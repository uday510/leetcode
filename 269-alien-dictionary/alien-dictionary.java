class Solution {
    public String alienOrder(String[] words) {
        
        int n = words.length;
        Map<Character, Set<Character>> adj = new HashMap<>();
        Map<Character, Integer> inorder = new HashMap<>();

        for (String w : words) {
            for (int j = 0; j < w.length(); j++) {
                char c = w.charAt(j);
                adj.putIfAbsent(c, new HashSet<>());
                inorder.putIfAbsent(c, 0);
            }
        }

        for (int i = 0; i < n - 1; i++) {
            String w1 = words[i], w2 = words[i + 1];

            if (w1.length() > w2.length() && w1.startsWith(w2)) 
                return new String();

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
            if (es.getValue() == 0) {
                queue.offer(es.getKey());
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            char u = queue.poll();
            sb.append(u);
            for (char v : adj.get(u)) {
                if (inorder.merge(v, -1, Integer::sum) == 0) {
                    queue.offer(v);
                }
            }
        }

        return sb.length() != inorder.size() ? new String() : sb.toString();
    }
}