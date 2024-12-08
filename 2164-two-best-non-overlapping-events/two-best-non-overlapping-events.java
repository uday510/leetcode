class Solution {
    public int maxTwoEvents(int[][] events) {
        Arrays.sort(events, (x, y) -> Integer.compare(x[0], y[0]));

        var pq = new PriorityQueue<Pair>((x, y) -> Integer.compare(x.end, y.end));
        var max = 0;
        var curr = 0;

        for (var event : events) {

            while (!pq.isEmpty() && pq.peek().end < event[0]) {
                curr = Math.max(curr, pq.poll().val);
            }

            max = Math.max(max, curr + event[2]);

            pq.offer(new Pair(event[1], event[2]));
        }

        return max;
    }

    private class Pair {
        int end;
        int val;

        Pair(int end, int val) {
            this.end = end;
            this.val = val;
        }
    }
}