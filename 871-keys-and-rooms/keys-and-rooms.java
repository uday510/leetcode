class Solution {

    List<List<Integer>> edges;
    Set<Integer> vis;

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        edges = rooms;
        vis = new HashSet<>();

        dfs(0);

        return vis.size() == edges.size();    
    }

    private void dfs(int u) {
        if (!vis.add(u)) return;

        for (int v : edges.get(u)) {
            dfs(v);
        }
    }
}

/**

0 -> 1 -> 2

 */