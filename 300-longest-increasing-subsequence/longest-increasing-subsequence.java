class Solution {

    List<Integer> lis;

    public int lengthOfLIS(int[] nums) {
        lis = new ArrayList<>();
        
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int index = bs(num);
            if (index == lis.size()) lis.add(num);
            lis.set(index, num);
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