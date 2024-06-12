class Solution {
    public void sortColors(int[] nums) {
        int p0 = 0; int p1 = 0; int p2 = nums.length-1;

        while (p1 <= p2) {
            if (nums[p1] == 0) {
                swap(p0, p1, nums);
                p0++;
                p1++;
            } else if (nums[p1] == 2) {
                swap(p1, p2, nums);
                p2--;
            } else {
                p1++;
            }
        }
    }
    public void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}