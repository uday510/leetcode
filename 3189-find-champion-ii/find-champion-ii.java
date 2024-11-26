class Solution {
    public int findChampion(int n, int[][] edges) {
        int[] inDegrees = new int[n];

        ArrayList<Integer>[] outgoingEdges = new ArrayList[n];
        for (int i = 0; i < n; ++i) {
            outgoingEdges[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            inDegrees[v]++;
            outgoingEdges[u].add(v);
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < n; ++i) {
            if (inDegrees[i] == 0) {
                queue.offer(i);
            }
        }

        return queue.size() == 1 ? queue.peek() : -1;
    }
}