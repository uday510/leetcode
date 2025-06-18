class Solution {
    int n;
    List<Integer> lis;
    public int maxEnvelopes(int[][] en) {
        n = en.length;

        Arrays.sort(en, (a, b) -> {
            if (a[0] == b[0]) return b[1] - a[1];
            return a[0] - b[0];
        });

        int[] arr = new int[n];
        for (int i = 0; i < n; ++i) arr[i] = en[i][1];

        lis = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            int index = bisectLeft(arr[i]);
            if (index == lis.size()) lis.add(arr[i]);
            lis.set(index, arr[i]);
        }

        System.out.println(lis);
        return lis.size();
    }
    private int bisectLeft(int target) {
        int i = 0, j = lis.size();

        while (i < j) {
            int mid = (i + j) >> 1;
            if (lis.get(mid) < target) i = mid + 1;
            else j = mid;
        }

        return i;
    }

}

/**


[3, 3, 4, 4, 7]

[3, 7]

 */