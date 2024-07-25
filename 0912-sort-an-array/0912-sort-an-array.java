class Solution {
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length-1);
        return nums;
    }
    public void quickSort(int[] nums, int low, int high) {
        if (high <= low)
            return;
        
        int pivot = partition(nums, low, high);
        quickSort(nums, low, pivot-1);
        quickSort(nums, pivot+1, high);
    }
    public int partition(int[] nums, int low, int high) {
        int ridx = ThreadLocalRandom.current().nextInt(low, high + 1);
        swap(nums, ridx, low);
        int idx = low;
        int pivot = nums[low];
            
        for (int i = low+1; i <= high; ++i) {
            if (nums[i] >= pivot) continue;
            
            ++idx;
            swap(nums, i, idx);
        }
        swap(nums, low, idx);
        return idx;
    }
    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}