class Solution {

    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        List<Integer>[] adjList = new ArrayList[n];

        for (int i = 0; i < n; ++i) adjList[i] = new ArrayList<>();

        for (int u = 0; u < n; ++u) {
            int v = edges[u];

            if (v == -1) continue;

            adjList[u].add(v);
        }

        Map<Integer, Integer> s1 = new HashMap<>();
        dfs(node1, s1, 0, adjList);

        Map<Integer, Integer> s2 = new HashMap<>();
        dfs(node2, s2, 0, adjList);

        int node = -1;
        int min = (int) 1e9;

        for (int i = 0; i < n; ++i) {
            
            if (s1.containsKey(i) && s2.containsKey(i)) {
                int curr = Math.max(s1.get(i), s2.get(i));
                if (curr < min) {
                    min = curr;
                    node = i;
                }
            }
        }

        return node;
    }

    private void dfs(int node, Map<Integer, Integer> seen, int dist, List<Integer>[] adjList) {

        if (seen.containsKey(node)) return;

        seen.put(node, dist);

        for (int next : adjList[node]) {
            dfs(next, seen, dist + 1, adjList);
        }
    }
}