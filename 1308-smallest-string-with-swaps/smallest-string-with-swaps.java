class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int len = s.length();
        DSU dsu = new DSU(len);

        for (var pair : pairs) {
            dsu.union(pair.get(0), pair.get(1));
        }

        var components = new HashMap<Integer, List<Integer>>();
        for (int vertex = 0; vertex < len; ++vertex) {
            int root = dsu.find(vertex);
            components.computeIfAbsent(root, k -> new ArrayList<>()).add(vertex);
        }

        char[] result = new char[len];
        for (var component : components.values()) {
            var chars = new ArrayList<Character>();
            for (int idx : component) {
                chars.add(s.charAt(idx));
            }
            Collections.sort(chars);
            for (int idx = 0; idx < component.size(); ++idx) {
                result[component.get(idx)] = chars.get(idx);
            }
        }

        return new String(result);
    }
    class DSU {
        int[] rank;
        int[] root;

        DSU(int n) {
            rank = new int[n];
            root = new int[n];

            for (int idx = 0; idx < n; ++idx) {
                rank[idx] = 1;
                root[idx] = idx;
            }
        }

        void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX == rootY) {
                return;
            }

            if (rank[rootX] > rank[rootY]) {
                root[rootY] = rootX;
            } else if (rank[rootY] > rank[rootY]) {
                rank[rootX] = rootY;
            } else {
                root[rootY] = rootX;
                rank[rootX]++;
            }
        }

        int find(int x) {
            if (x == root[x]) {
                return x;
            }
            return root[x] = find(root[x]);
        }
    }

}