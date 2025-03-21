class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        int n = recipes.length;
        Map<String, List<String>> adjList = new HashMap<>();
        Map<String, Integer> indegree = new HashMap<>();
        Set<String> seen = new HashSet<>(Arrays.asList(recipes));

        for (int idx = 0; idx < n; ++idx) {
            String v = recipes[idx];
            var ingredient = ingredients.get(idx);

            for (String u : ingredient) {
                adjList.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
                indegree.merge(v, 1, Integer::sum);
            }
        }

        Deque<String> queue = new ArrayDeque<>();
        List<String> result = new ArrayList<>();
        
        for (String s : supplies) {
            queue.offer(s);
        }

        while (!queue.isEmpty()) {

            String u = queue.poll();
            if (seen.contains(u)) 
                result.add(u);

            for (String v : adjList.getOrDefault(u, new ArrayList<>())) {
                indegree.merge(v, -1, Integer::sum);

                if (indegree.get(v) == 0)
                    queue.offer(v);
            }
        }

        return result;
    }
}
