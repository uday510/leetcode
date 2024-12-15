class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((x, y) -> Double.compare(profit(y[0], y[1]), profit(x[0], x[1])));
        double result = 0;
        int current = extraStudents;
        int len = classes.length;
        int[] polled;

        for (int[] _class : classes) {
            priorityQueue.offer(new int[] {_class[0], _class[1]});
        }

        while (current-- > 0) {
            polled = priorityQueue.poll();

            ++polled[0];
            ++polled[1];

            priorityQueue.offer(polled);
        }

        while (!priorityQueue.isEmpty()) {
            polled = priorityQueue.poll();

            result += (double) polled[0] / polled[1];
        }

        return result / len;

    }

    private double profit(int x, int y) {
        double before = (double) x / y;
        double after = (double) (x + 1 ) / (y + 1);

        return after - before;
    }
}