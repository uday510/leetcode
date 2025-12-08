class Solution {
    public int minimumDeletions(int[] nums) {

     int n = nums.length;

     int minIdx = -1, maxIdx = -1;

     int minVal = Integer.MAX_VALUE, maxVal = Integer.MIN_VALUE;

     for (int i = 0; i < n; i++) {
        int num = nums[i];

        if (num < minVal) {
            minVal = num;
            minIdx = i;
        }
        
        if (num > maxVal) {
            maxVal = num;
            maxIdx = i;
        }

     }


     
     int res = -1;

     if (maxIdx < minIdx) {
        int op1 = n - minIdx + maxIdx + 1;
        int op2 = minIdx + 1;
        int op3 = n - maxIdx;
        res = Math.min(op1, Math.min(op2, op3));
     } else {
        System.out.println("vfg");
        int op1 = n - maxIdx + minIdx + 1; // 3 - 2 + 1 + 1 // 3
        int op2 = maxIdx + 1; // 3
        int op3 = n - minIdx; // 3 - 1 // 2
        res = Math.min(op1, Math.min(op2, op3));
     }

     return res;

    }
}