class Solution {
    public int pivotInteger(int n) {
        if (n == 1) return n;
        
        int leftIdx = 1;
        int rightIdx = n;
        int leftSum = 1;
        int rightSum = n;

        while (rightIdx >= leftIdx) {
            if (leftSum <= rightSum) {
                leftSum += ++leftIdx;
            } else {
                rightSum += --rightIdx;
            }
            if (leftSum - rightSum == 0 && leftIdx == rightIdx) {
                return leftIdx;
            }
        }
        return -1;
    }
}