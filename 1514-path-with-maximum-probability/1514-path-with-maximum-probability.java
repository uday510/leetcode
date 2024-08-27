class Solution {
    private final double INTIAL_PROBABILITY = 1.0;
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        var graph = buildGraph(edges, succProb);

        double[] probablities = new double[n];
        probablities[start] = INTIAL_PROBABILITY;

        PriorityQueue<Hop<Integer, Double>> priorityQueue =
         new PriorityQueue<>((o1, o2 ) -> Double.compare(o2.getWeight(), o1.getWeight()));

        priorityQueue.offer(new Hop<>(start, INTIAL_PROBABILITY));

        while (!priorityQueue.isEmpty()) {
            var currentHop = priorityQueue.poll();
            int currentNode = currentHop.getDestination();
            double currentProbability = currentHop.getWeight();

            if (currentNode == end) {
                return currentProbability;
            }

            for (var nextHop : graph.getOrDefault(currentNode, Collections.emptyList())) {
                int nextNode = nextHop.getDestination();
                double nextProbability = nextHop.getWeight() * currentProbability;

                if (nextProbability > probablities[nextNode]) {
                    priorityQueue.offer(new Hop<>(nextNode, nextProbability));
                    probablities[nextNode] = nextProbability;
                }
            }
        }
        return 0d;
    }
    private class Hop<T1, T2> {
        T1 destination;
        T2 weight;

        public Hop(T1 node, T2 distance) {
            this.destination = node;
            this.weight = distance;
        }
        public T1 getDestination() {
            return destination;
        }
        public T2 getWeight() {
            return weight;
        }
    }
    private Map<Integer, List<Hop<Integer, Double>>> buildGraph(int[][] edges, double[] succProb) {
        Map<Integer, List<Hop<Integer, Double>>> graph = new HashMap<>();

        for (int i = 0; i < edges.length; ++i) {
            int u = edges[i][0];
            int v = edges[i][1];
            double probability = succProb[i];
            graph.computeIfAbsent(u, k -> new ArrayList<>()).add(new Hop<>(v, probability));
            graph.computeIfAbsent(v, k -> new ArrayList<>()).add(new Hop<>(u, probability));
        }
        return graph;
    }
}