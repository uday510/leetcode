class Solution {
    public int[] sortByBits(int[] arr) {
        int n = arr.length;
        Integer[] tmp = new Integer[n];
        for (int i = 0; i < n; ++i) tmp[i] = arr[i];

        Arrays.sort(tmp, (o1, o2) -> {
            int cnt1 = Integer.bitCount(o1);
            int cnt2 = Integer.bitCount(o2);

            if (cnt1 == cnt2) return o1 - o2;
            return cnt1 - cnt2;
        });

        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = tmp[i];
        }

        return res;
    }
}