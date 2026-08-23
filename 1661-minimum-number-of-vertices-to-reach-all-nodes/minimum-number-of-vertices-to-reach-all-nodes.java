class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        
        int[] in = new int[n];
        for (var e : edges) {
            in[e.getLast()]++;
        }

        List<Integer> res = new ArrayList<>();
        for (int idx = 0; idx < n; idx++) {
            if (in[idx] == 0)
                res.add(idx);
        }

        return res;
    }
}