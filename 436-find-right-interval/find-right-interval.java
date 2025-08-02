class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        int[] arr = new int[n];
        Map<Integer, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; ++i) {
            arr[i] = intervals[i][0];
            map.put(intervals[i][0], i);
            sb.append(intervals[i][1] + " ");
        }

        Arrays.sort(arr);
        System.out.println("star " + Arrays.toString(arr));
        System.out.println("ends " + sb);

        int[] res = new int[n];

        for (int i = 0; i < n; ++i) {
            int c = -1;
            int idx = -1;
            try {
                idx = bs(intervals[i][1], arr);
                res[i] = map.get(arr[idx]);
                System.out.println(intervals[i][1] + " : " + idx);
            } catch(Exception ex) {
                System.out.println(intervals[i][1] + " exc " + idx);
                res[i] = -1;
            }
        }

        return res;
    }

    private int bs(int t, int[] arr) {
        int l = 0;
        int r = arr.length;

        while (l < r) {
            int m = (l + r) >> 1;

            if (arr[m] < t) l = m + 1;
            else r = m;
        }

        return l;
    }
}

//    [2, 3, 4] ends
// bs [1, 2, 3] starts