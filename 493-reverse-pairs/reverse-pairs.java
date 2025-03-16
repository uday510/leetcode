class Solution {
    int cnt;
    public int reversePairs(int[] nums) {
        cnt = 0;
        mergesort(0, nums.length - 1, nums);
        return cnt;
    }
    private void mergesort(int leftIdx, int rightIdx, int[] nums) {
        if (leftIdx >= rightIdx) {
            return;
        }

        int midIdx = (leftIdx + rightIdx) >> 1;

        mergesort(leftIdx, midIdx, nums);
        mergesort(midIdx + 1, rightIdx, nums);
        countPairs(leftIdx, midIdx, rightIdx, nums);
        merge(leftIdx, midIdx, midIdx + 1, rightIdx, nums);
    }

    private void merge(int leftStartIdx, int leftEndIdx, int rightStartIdx, int rightEndIdx, int[] nums) {
        int[] leftArray = new int[leftEndIdx - leftStartIdx + 1];
        int[] rightArray = new int[rightEndIdx - rightStartIdx + 1];

        for (int idx = 0; idx < leftArray.length; ++idx) {
            leftArray[idx] = nums[idx + leftStartIdx];
        }

        for (int idx = 0; idx < rightArray.length; ++idx) {
            rightArray[idx] = nums[idx + rightStartIdx];
        }

        int i = 0;
        int j = 0;
        int k = leftStartIdx;

        while (i < leftArray.length && j < rightArray.length) {
            if (leftArray[i] < rightArray[j]) {
                nums[k++] = leftArray[i++];
            } else {
                nums[k++] = rightArray[j++];
            }
        }

        while (i < leftArray.length) {
            nums[k++] = leftArray[i++];
        }

        while (j < rightArray.length) {
            nums[k++] = rightArray[j++];
        }
    }
    private void countPairs(int leftIdx, int midIdx, int rightIdx, int[] nums) {
        int j = midIdx + 1;
        while (leftIdx <= midIdx) {

            while (j <= rightIdx && nums[leftIdx] > 2L * nums[j]) {
                j++;
            }
            cnt += (j - midIdx - 1);
            leftIdx++;
        }
    }
}

