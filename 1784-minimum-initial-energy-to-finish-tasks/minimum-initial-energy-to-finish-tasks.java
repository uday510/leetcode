class Solution {

    private int[][] tasks;

    public int minimumEffort(int[][] tasks) {
        this.tasks = tasks;

        Arrays.sort(tasks, (a, b) -> (b[1] - b[0]) - (a[1] - a[0]));

        int l = tasks[0][1], r = 0;

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
            if (limit < t[1]) {
                return false;
            }
            
            limit -= t[0];
        }

        return true;
    }

}
