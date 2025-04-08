class Solution {
    public List<Integer> addToArrayForm(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();

        int curr = k;
        int idx = nums.length - 1;

        while (idx > -1 || curr > 0) {
            if (idx > -1) curr += nums[idx--];
            list.add(curr % 10);
            curr /= 10;
        }

        Collections.reverse(list);
        return list;
    }
}