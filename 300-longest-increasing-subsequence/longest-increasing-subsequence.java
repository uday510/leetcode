class Solution {

    private int n;
    private int[] arr;
    private List<Integer> lis;

    public int lengthOfLIS(int[] arr) {
        n = arr.length;
        this.arr = arr;
        lis = new ArrayList<>();


        for (int i = 0; i < n; i++) {
            int index = bs(arr[i]);
            if (index == lis.size()) lis.add(arr[i]);
            lis.set(index, arr[i]);
        }

        return lis.size();
    }

    private int bs(int t) {
        int l = 0, r = lis.size();

        while (l < r) {

            int m = l + ((r - l) >> 1);

            if (lis.get(m) < t) l = m + 1;
            else r = m;
        }

        return l;
    }
}