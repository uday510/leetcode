class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] products = new int[n];

        int curr = 1;
        for (int i = 0; i < n; ++i) {
            products[i] = curr;
            curr *= nums[i];
        }
        curr = 1;
        for (int i = n - 1; i > -1; --i) {
            products[i] *= curr;
            curr *= nums[i];
        }

        return products;
    }
}