class Solution {
    public boolean isTrionic(int[] nums) {

        boolean incres = false;
        boolean decres = false;
        int i = 0;
        int n = nums.length - 1;

        while (i < n && !incres) {
            if (nums[i] >= nums[i + 1]) {
                incres = false;
                break;
            }
            i++;
        }

        if (i == 0 || i == n - 1) return false;

            while (i < n && !decres) {
            if (nums[i] <= nums[i + 1]) {
                decres = false;
                break;
            }
            i++;
        }

        if (i == n) return false;

        while (i < n && !incres) {
            if (nums[i] >= nums[i + 1]) {
                incres = false;
                break;
            }
            i++;
        }

        return i == n;
    }
}