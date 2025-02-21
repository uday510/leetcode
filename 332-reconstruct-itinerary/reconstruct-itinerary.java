class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        List<String> result = new LinkedList<>();
        Deque<String> stack = new ArrayDeque<>();
        Map<String, PriorityQueue<String>> graph = new HashMap<>();

        for (List<String> ticket : tickets) {
            String source = ticket.getFirst();
            String destination = ticket.getLast();

            graph.computeIfAbsent(source, k -> new PriorityQueue<>()).offer(destination);
        }

        stack.push("JFK");

        while (!stack.isEmpty()) {
            String curr = stack.peek();

            if (graph.containsKey(curr) && !graph.get(curr).isEmpty()) {
                stack.push(graph.get(curr).poll());
            } else {
                result.addFirst(stack.pop());
            }
        }

        return result;
    }
}