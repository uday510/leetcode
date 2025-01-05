class Solution {

    // 0 -> [ [1,2], [2, 3] ]
    // 1 -> []

    Map<Integer, List<int[]>> graph;
    int threshold;
    int result;
    int n;

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        intialize(edges, distanceThreshold, n);

        int city = Integer.MAX_VALUE;
        int index = Integer.MAX_VALUE;
        for (int node = 0; node < n; ++node) {
            int currentCities = bfs(node);

            if (currentCities <= city) {
                index = node;
                city = currentCities;
            }

        }

        return index;
   }
   private int bfs(int node) {
    int[] distances = new int[n];
    Arrays.fill(distances, Integer.MAX_VALUE);
    distances[node] = 0;

    Queue<int[]> queue = new LinkedList<>();
    queue.offer(new int[]{node, 0});

    while (!queue.isEmpty()) {
        int[] edge = queue.poll();
        int currNode = edge[0];
        int dist = edge[1];
        
        if (distances[currNode] < dist) {
            continue;
        }

        for (var next : graph.getOrDefault(currNode, new ArrayList<int[]>())) {
            int nextNode = next[0];
            int nextDist = next[1] + dist;

            if (distances[nextNode] <= nextDist) {
                continue;
            }

            queue.offer(new int[]{nextNode, nextDist});
            distances[nextNode] = nextDist;
        }
    }

    int current = 0;

    for (int idx = 0; idx < n; ++idx) {
        if (idx != node && distances[idx] <= threshold) {
            current += 1;
        }
    }

    return current;
   }

   private void intialize(int[][] edges, int threshold, int n) {
        graph = new HashMap<>();
        this.threshold = threshold;
        result = Integer.MAX_VALUE;
        this.n = n;

        for (int[] edge : edges) {
            int src = edge[0];
            int dest = edge[1];
            int dist = edge[2];

            // src --> dest
            graph.computeIfAbsent(src, x -> new ArrayList<>()).add(new int[]{dest, dist});

            // dest --> src
            graph.computeIfAbsent(dest, x -> new ArrayList<>()).add(new int[]{src, dist});
        }
   }

}





/***

1. find all the reachable cities with threshold for the cities
2. out of the cities find the smallest number of cities,
3. if multiples are applicable then return with greatest city
    else 

 */