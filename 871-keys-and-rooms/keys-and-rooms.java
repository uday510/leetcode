class Solution {
    List<List<Integer>> adjList;
    Set<Integer> vis;
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        adjList = rooms;
        vis = new HashSet<>();

        dfs(0);

        return vis.size() == rooms.size();
    }

    private void dfs(int node) {
        if (!vis.add(node)) return;

        for (int nei : adjList.get(node)) {
            dfs(nei);
        }
    }
}