class Solution {
    int[] nums;
    int len;
    public void rotate(int[] nums, int k) {
        this.nums = nums;
        len = nums.length;
        k = k % len;

        reverse(0, len - 1);
        reverse(0, k - 1);
        reverse(k, len - 1);
    }

    private void reverse(int leftIdx, int rightIdx) {
        while (leftIdx < rightIdx) {
            swap(leftIdx, rightIdx);
            leftIdx++;
            rightIdx--;
        }
    }

    private void swap(int leftIdx, int rightIdx) {
        int temp = nums[leftIdx];
        nums[leftIdx] = nums[rightIdx];
        nums[rightIdx] = temp;
    }
}



/**

1,2,3,4,5,6,7]


 */