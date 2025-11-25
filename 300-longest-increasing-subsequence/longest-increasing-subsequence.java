class Solution {

    int n;
    List<Integer> lis;

    public int lengthOfLIS(int[] nums) {
        n = nums.length;
        lis = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int num = nums[i];

            int nxtIdx = bs(num);
            if (nxtIdx == lis.size()) lis.add(nxtIdx);
            lis.set(nxtIdx, num);
        }

        return lis.size();
    }

    private int bs(int target) {
        int l = 0, r = lis.size();

        while (l < r) {
            int m = (l + r) >> 1;

            if (lis.get(m) < target) l = m + 1;
            else r = m;
        }

        return l;
    }
}