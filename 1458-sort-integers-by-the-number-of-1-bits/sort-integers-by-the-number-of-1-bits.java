class Solution {
    public int[] sortByBits(int[] arr) {
        int n = arr.length;
        Integer[] tmp = new Integer[n];
        for (int i = 0; i < n; ++i) tmp[i] = arr[i];

        Arrays.sort(tmp, (o1, o2) -> {
            int c1 = Integer.bitCount(o1);
            int c2 = Integer.bitCount(o2);

            if (c1 != c2) {
                return c1 - c2;
            }

            return Integer.compare(o1, o2);

        });

        int[] res = new int[n];
        
        for (int i = 0; i < n; i++) {
            res[i] = tmp[i];
        }

        return res;
    }
}