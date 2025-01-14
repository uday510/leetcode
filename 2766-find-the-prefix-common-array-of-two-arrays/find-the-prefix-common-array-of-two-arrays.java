class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int[] frequency = new int[51];
        int[] result = new int[A.length];
        int common = 0;

        for (int idx = 0; idx < A.length; ++idx) {
            frequency[A[idx]]++;

            if (frequency[A[idx]] == 2) {
                common++;
            }

            frequency[B[idx]]++;
            if (frequency[B[idx]] == 2) {
                common++;
            }

            result[idx] = common;
        }

        return result;
    }
}