public class ZigzagIterator {

    Queue<Iterator> queue;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        queue = new ArrayDeque<>();

        if (!v1.isEmpty()) queue.offer(v1.iterator());
        if (!v2.isEmpty()) queue.offer(v2.iterator());
    }

    public int next() {
        Iterator curr = queue.poll();
        int result = (int) curr.next();
        if (curr.hasNext()) queue.offer(curr);
        return result;
    }

    public boolean hasNext() {
        return !queue.isEmpty();
    }
}