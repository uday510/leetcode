class Solution {
    int n;
    List<Integer>[] adjList;
    Set<Integer> vis;
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        initialize(rooms);

        dfs(0);

        return vis.size() == n;
    }

    private void dfs(int node) {
        if (!vis.add(node)) return;

        for (int nei : adjList[node]) {
            dfs(nei);
        }
    }

    private void initialize(List<List<Integer>> rooms) {
        n = rooms.size();
        adjList = new ArrayList[n];
        vis = new HashSet<>();

        for (int i = 0; i < n; ++i) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; ++i) {
            for (int neighbor : rooms.get(i)) {
                adjList[i].add(neighbor);
            }
        }
    }
}