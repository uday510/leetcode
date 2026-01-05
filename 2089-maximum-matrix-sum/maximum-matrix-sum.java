class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long sum = 0;
        int negative = 0;
        int minVal = 100000;

        for (int[] row : matrix) {
            for (int val : row) {
                sum += Math.abs(val);

                if (val < 0) {
                    ++negative;
                }

                negative %= 2;

                minVal = Math.min(minVal, Math.abs(val));
            }
        }

        if (negative == 1) {
            sum -= 2 * minVal;
        }

        return sum;
    }
}