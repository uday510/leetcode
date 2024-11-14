class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        var graph = new HashMap<Integer, List<Integer>>();
        var indegree = new int[numCourses];
        var queue = new LinkedList<Integer>();
        var res = new int[numCourses];

        for (int i = 0; i < numCourses; ++i) {
            graph.put(i, new ArrayList<>());
        }

        for (int[] pre : prerequisites) {
            
            graph.get(pre[1]).add(pre[0]);
            ++indegree[pre[0]];
        }

        for (int i = 0; i < indegree.length; ++i) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int vis = 0;
        int index = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            ++vis;
            res[index++] = node;

            List<Integer> neighbors = graph.get(node);

            for (int nei : neighbors) {

                --indegree[nei];

                if (indegree[nei] == 0) {
                    queue.offer(nei);
                }
            }
        }

       return vis == numCourses ? res : new int[]{};
    }
}