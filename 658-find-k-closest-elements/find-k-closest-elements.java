class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> list = new ArrayList<>();
        int n = arr.length;
        int l = 0;
        int r = n;
        
        while (l < r) {
            int m = (l + r) >> 1;

            if (arr[m] < x) l = m + 1;
            else r = m;
        }

        r = l;

        while (r - l - 1 < k) {
            if (l == -1) {
                r++;
                continue;
            }

            if (r == n || Math.abs(arr[l] - x) <= Math.abs(arr[r] - x)) {
                l--;
            } else {
                r++;
            }
        }

        for (int i = l + 1; i < r; ++i) {
            list.add(arr[i]);
        }

        return list;
    }
}