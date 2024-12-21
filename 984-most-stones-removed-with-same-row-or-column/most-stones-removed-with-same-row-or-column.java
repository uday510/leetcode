class Solution {
    public int removeStones(int[][] stones) {
        UF uf = new UF(200000);

        for (int[] stone : stones) {
            uf.union(stone[0], stone[1] + 100000);
        }

        Set<Integer> uniqueRoots = new HashSet<>();
        for (int[] stone : stones) {
            uniqueRoots.add(uf.find(stone[0]));
        }

        return stones.length - uniqueRoots.size();
    }

    private class UF {
        int[] rank;
        int[] root;

        UF(int n) {
            rank = new int[n];
            root = new int[n];
            for (int i = 0; i < n; i++) {
                root[i] = i;
                rank[i] = 1;
            }
        }

        private void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX != rootY) {
                if (rank[rootX] > rank[rootY]) {
                    root[rootY] = rootX;
                } else if (rank[rootX] < rank[rootY]) {
                    root[rootX] = rootY;
                } else {
                    root[rootY] = rootX;
                    rank[rootX]++;
                }
            }
        }

        private int find(int x) {
            if (x != root[x]) {
                root[x] = find(root[x]); 
            }
            return root[x];
        }
    }
}