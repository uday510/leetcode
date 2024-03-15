class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] products = new int[len];
        
        int leftRunningProduct = 1;
        for (int i = 0; i < len; ++i) {
            products[i] = leftRunningProduct;
            leftRunningProduct *= nums[i];
        }
        
        int rightRunningProduct = 1;
        for (int i = len - 1; i > -1; --i) {
            products[i] *= rightRunningProduct;
            rightRunningProduct *= nums[i];
        }
        
        return products;
    }
}