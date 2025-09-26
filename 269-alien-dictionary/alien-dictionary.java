class Solution {
    public String alienOrder(String[] words) {
        Map<Character, List<Character>> adj = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();
        int n = words.length;

        for (String w : words) {
            for (int i = 0; i < w.length(); i++) {
                indegree.put(w.charAt(i), 0);
            }
        }

        for (int i = 0; i < n; i++) {
            String w1 = words[i];
            for (int j = i + 1; j < n; j++) {
                String w2 = words[j];

                if (w1.length() > w2.length() && w1.startsWith(w2)) return "";

                for (int k = 0; k < Math.min(w1.length(), w2.length()); k++) {
                    char c1 = w1.charAt(k), c2 = w2.charAt(k);

                    if (c1 == c2) continue;

                    adj.computeIfAbsent(c1, _ -> new ArrayList<>()).add(c2);
                    indegree.merge(c2, 1, Integer::sum);
                    break;
                }
            }
        }

        Queue<Character> queue = new ArrayDeque<>();

        for(var e : indegree.entrySet()) {
            char k = e.getKey();
            int v = e.getValue();

            if (v == 0) queue.offer(k);
        }

        StringBuilder sb = new StringBuilder();

        while (!queue.isEmpty()) {
            char u = queue.poll();

            sb.append(u);
            for (char v : adj.getOrDefault(u, new ArrayList<>())) {
                indegree.merge(v, -1, Integer::sum);
                if (indegree.get(v) == 0) {
                    queue.offer(v);
                }
            }
        }

        if (indegree.size() != sb.length()) return "";

        return sb.toString();

    }
}