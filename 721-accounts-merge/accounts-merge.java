class Solution {
    Map<String, List<String>> adj;
    Set<String> vis;
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        adj = new HashMap<>();
        vis = new HashSet<>();

        for (var act : accounts) {
            String u = act.get(1);
            for (int i = 2; i < act.size(); i++) {
                String v = act.get(i);
                adj.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
                adj.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
            }
        }

        List<List<String>> res = new ArrayList<>();

        for (var act : accounts) {
            String name = act.get(0);
            String u = act.get(1);

            if (vis.contains(u)) continue;

            List<String> cur = new ArrayList<>();
            cur.add(name);

            dfs(u, cur);

            Collections.sort(cur.subList(1, cur.size()));
            res.add(cur);
        }

        return res;    
    }

    private void dfs(String email, List<String> cur) {
        vis.add(email);
        cur.add(email);

        for (String v : adj.getOrDefault(email, new ArrayList<>())) {
            if (vis.contains(v)) continue;
            dfs(v, cur);
        }
    }

}