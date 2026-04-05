class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            arr[i][0] = intervals[i][0];
            arr[i][1] = i;
        }

        Arrays.sort(arr, Comparator.comparingInt(k -> k[0]));

        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            int[] in = intervals[i];

            int index = bs(arr, in[1]);
            res[i] = index == n ? -1 : arr[index][1];
        }

        return res;
    }

    private int bs(int[][] arr, int t) {
        int l = 0, r = arr.length;

        while (l < r) {
            int m = l + (r - l) / 2;

            if (arr[m][0] < t) l = m + 1;
            else r = m;
        }

        return l;
    }
}

/**

[1, 2, 2] [2, 3, 1] [3, 4, 0]

[3, 4] [2, 3] [1, 2]


-1 0 1


 */