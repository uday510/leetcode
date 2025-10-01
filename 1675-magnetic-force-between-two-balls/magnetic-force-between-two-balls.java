class Solution {
    public int maxDistance(int[] A, int balls) {
        Arrays.sort(A);

        int l = 1, r = A[A.length - 1];

        while (l < r) {
            int m = (l + r) >> 1;

            if (canPlace(A, m, balls)) l = m + 1;
            else r = m;
        }

        return l - 1;
    }
    private boolean canPlace(int[] A, int dist, int totalballs) {
        int curballs = 1;
        int prevPos = A[0];

        for (int i = 0; i < A.length; i++) {
            int curPos = A[i];

            if (curPos - prevPos >= dist) {
                curballs++;
                prevPos = curPos;
                if (curballs >= totalballs) return true;
            }
        }

        return curballs >= totalballs;
    }
}