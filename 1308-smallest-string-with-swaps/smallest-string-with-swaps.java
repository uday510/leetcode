class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int n = s.length();
        UnionFind uf = new UnionFind(n);

        for (List<Integer> p : pairs) {
            uf.union(p.get(0), p.get(1));
        }

        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int root = uf.find(i);
            map.computeIfAbsent(root, k -> new ArrayList<>()).add(i);
        }

        char[] res = new char[n];

        for (List<Integer> v : map.values()) {
            List<Character> chars = new ArrayList<>();
            for (int i : v) {
                chars.add(s.charAt(i));
            }

            Collections.sort(chars);
            for (int i = 0; i < v.size(); i++) {
                res[v.get(i)] = chars.get(i);
            }
        }

        return new String(res);
    }

    class UnionFind {
        int[] root, rank;

        UnionFind(int n) {
            root = new int[n];
            rank = new int[n];

            for (int i = 0; i < n; i++) {
                root[i] = i;
                rank[i] = 1;
            }
        }

        void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX == rootY) return;

            if (rank[rootX] > rank[rootY]) {
                root[rootY] = rootX;
            } else if (rank[rootY] > rank[rootX]) {
                root[rootX] = rootY;
            } else {
                root[rootY] = rootX;
                rank[rootX]++;
            }
        }
        
        int find(int x) {
            if (root[x] == x) return x;

            return root[x] = find(root[x]);
        }

        boolean connected(int x, int y) {
            return find(x) == find(y);
        }
    }
}