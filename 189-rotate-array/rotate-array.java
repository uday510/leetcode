class Solution {

    private int[] nums;

    public void rotate(int[] nums, int k) {
        this.nums = nums;
        int n = nums.length;
        k %= n;

        rotate(0, n - 1);
        rotate(0, k - 1);
        rotate(k, n - 1);
        
    }

    private void rotate(int i, int j) {
        while (i < j) swap(i++, j--);
    }

    private void swap(int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}