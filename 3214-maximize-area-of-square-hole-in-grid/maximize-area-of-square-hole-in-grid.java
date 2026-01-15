class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] H, int[] V) {
        int hMax = getMaxConsecutive(H);
        int vMax = getMaxConsecutive(V);

        int side = Math.min(hMax, vMax) + 1;

        return side * side;

    }

    private int getMaxConsecutive(int[] arr) {
        Arrays.sort(arr);
        int cur, max;

        cur = max = 1;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1] + 1) {
                cur++;
            } else {
                cur = 1;
            }

            max = Math.max(max, cur);
        }

        return max;
    }

}