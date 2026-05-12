class Solution {

    private int[][] tasks;

    public int minimumEffort(int[][] tasks) {
        this.tasks = tasks;

        Arrays.sort(tasks, (a, b) -> (b[1] - b[0]) - (a[1] - a[0]));

        int l = tasks[0][1], r = 1;

        for (int[] t : tasks) r += t[1];

        while (l < r) {

            int m = l + ((r - l) >> 1);

            if (isPossible(m)) {
                r = m;
            } else {
               l = m + 1;
            }

        }

        return l;
    }

    private boolean isPossible(int limit) {

        for (int[] t : tasks) {

            int actual = t[0];
            int minimum = t[1];

            if (limit < minimum) {
                return false;
            }

            limit -= actual;
        }

        return true;
    }

}
