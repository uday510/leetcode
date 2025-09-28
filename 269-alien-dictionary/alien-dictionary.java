class Solution {
    public String alienOrder(String[] words) {
        Map<Character, List<Character>> adj = new HashMap<>();
        Map<Character, Integer> inorder = new HashMap<>();
        int n = words.length;

        for (String w : words) {
            for (char c : w.toCharArray()) {
                adj.putIfAbsent(c, new ArrayList<>());
                inorder.putIfAbsent(c, 0);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                
                int m = Math.min(words[i].length(), words[j].length());

                for (int k = 0; k < m; k++) {
                    String w1 = words[i], w2 = words[j];

                    // "abcd", "ab" invalid 
                    if (w1.length() > w2.length() && w1.startsWith(w2)) return "";

                    char c1 = w1.charAt(k), c2 = w2.charAt(k);

                    if (c1 == c2) continue;

                    adj.computeIfAbsent(c1, _ -> new ArrayList<>()).add(c2);
                    inorder.merge(c2, 1, Integer::sum);
                    break;
                }
            }
        }

        Queue<Character> queue = new ArrayDeque<>();

        for (var e : inorder.entrySet()) {
            char k = e.getKey();
            int v = e.getValue();

            if (v == 0) {
                queue.offer(k);
            }
        }

        StringBuilder sb = new StringBuilder();

        while (!queue.isEmpty()) {
            char cur = queue.poll();

            sb.append(cur);

            for (char v : adj.getOrDefault(cur, new ArrayList<>())) {
                inorder.merge(v, -1, Integer::sum);

                if (inorder.get(v) == 0) {
                    queue.offer(v);
                }
            }
        }

        if (sb.length() != inorder.size()) {
            return "";
        }

        return sb.toString();
    }
}