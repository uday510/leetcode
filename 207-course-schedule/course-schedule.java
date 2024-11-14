class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        var indegree = new int[numCourses];
        var graph = new HashMap<Integer, List<Integer>>();
        var queue = new LinkedList<Integer>();

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

        while (!queue.isEmpty()) {
            int ele = queue.poll();
            ++vis;

            List<Integer> neigs = graph.get(ele);

            System.out.println(ele + " " + neigs);

            for (int nei : neigs) {

                --indegree[nei];

                if (indegree[nei] == 0) {
                    queue.offer(nei);
                }
            }
        }
        return vis == numCourses;
    }
}