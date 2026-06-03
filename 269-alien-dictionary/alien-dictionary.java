class Solution {

    public String alienOrder(String[] words) {
        
        Map<Character, Set<Character>> adj = new HashMap<>();
        Map<Character, Integer> in = new HashMap<>();

        for (String w : words) {
            for (int i = 0; i < w.length(); i++) {
                char c = w.charAt(i);
                adj.putIfAbsent(c, new HashSet<>());
                in.putIfAbsent(c, 0);
            }
        }

        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i], w2 = words[i + 1];

            if (w1.length() > w2.length() && w1.startsWith(w2)) {
                return "";
            }

            int m = Math.min(w1.length(), w2.length());

            for (int j = 0; j < m; j++) {
                char c1 = w1.charAt(j), c2 = w2.charAt(j);

                if (c1 != c2) {
                    if (!adj.get(c1).contains(c2)) {
                        adj.get(c1).add(c2);
                        in.put(c2, in.get(c2) + 1);
                    }
                    break;
                }
            }
        }

        Queue<Character> queue = new ArrayDeque<>();

        for (Map.Entry<Character, Integer> e : in.entrySet()) {
            if (e.getValue() == 0) queue.offer(e.getKey());
        }

        StringBuilder sb = new StringBuilder();

        while (!queue.isEmpty()) {
            char u = queue.poll();
            sb.append(u);

            for (char v : adj.get(u)) {
                in.put(v, in.get(v) - 1);

                if (in.get(v) == 0) {
                    queue.offer(v);
                }
            }
        }

        if (sb.length() != in.size()) return "";

        return sb.toString();

    }
}