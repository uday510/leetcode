class Solution {
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        int numGroups = m;
        for (int i = 0; i < n; i++) {
            if (group[i] == -1) {
                group[i] = numGroups++;
            }
        }

        List<Integer>[] itemsAdjList = new ArrayList[n];
        int[] itemsIndegree = new int[n];
        for (int i = 0; i < n; i++) itemsAdjList[i] = new ArrayList<>();

        List<Integer>[] grpsAdjList = new ArrayList[numGroups];
        int[] grpsIndegree = new int[numGroups];
        for (int i = 0; i < numGroups; i++) grpsAdjList[i] = new ArrayList<>();

        for (int v = 0; v < n; v++) {
            for (int u : beforeItems.get(v)) {
                itemsAdjList[u].add(v);
                itemsIndegree[v]++;

                if (group[u] != group[v]) {
                    grpsAdjList[group[u]].add(group[v]);
                    grpsIndegree[group[v]]++;
                }
            }
        }

        List<Integer> itemsOrder = topo(itemsAdjList, itemsIndegree);
        if (itemsOrder.isEmpty()) return new int[]{};

        List<Integer> grpsOrder = topo(grpsAdjList, grpsIndegree);
        if (grpsOrder.isEmpty()) return new int[]{};

        Map<Integer, List<Integer>> order = new HashMap<>();
        for (int i : itemsOrder) {
            order.computeIfAbsent(group[i], _ -> new ArrayList<>()).add(i);
        }

        List<Integer> res = new ArrayList<>();
        for (int g : grpsOrder) {
            if (order.containsKey(g)) {
                res.addAll(order.get(g));
            }
        }

        return res.stream().mapToInt(Integer::intValue).toArray();

    }

    private List<Integer> topo(List<Integer>[] adjList, int[] indegree) {
        int n = indegree.length;
        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) queue.offer(i);
        }

        List<Integer> visited = new ArrayList<>();
        while (!queue.isEmpty()) {
            int u = queue.poll();
            visited.add(u);

            for (int v : adjList[u]) {
                if (--indegree[v] == 0) {
                    queue.offer(v);
                }     
            }
        }

        return visited.size() == n ? visited : new ArrayList<>();
    }
}