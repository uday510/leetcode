class Solution {
    public int[] findRightInterval(int[][] intvs) {
        int n = intvs.length;
        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            int[] in = intvs[i];
            arr[i][0] = in[0];
            arr[i][1] = i;
        }

        Arrays.sort(arr, Comparator.comparingInt(k -> k[0]));

        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int idx = bs(arr, intvs[i][1]);
            res[i] = idx == arr.length ? -1 : arr[idx][1];
        }

        return res;
    }

    private int bs(int[][] arr, int t) {
        int l = 0, r = arr.length;

        while (l < r) {
            int m = l + ((r - l) >> 1);

            if (arr[m][0] < t) l = m + 1;
            else r = m;
        }

        return l;
    }
}

/**


 { [1, 0] [2, 1] [3, 0] }
 { [3, 4] [2, 3] [1, 2] }

i = 0
t = 


 */