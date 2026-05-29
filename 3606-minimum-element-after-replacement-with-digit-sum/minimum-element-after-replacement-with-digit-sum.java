class Solution {

    public int minElement(int[] nums) {
     
     int mn = (int) 1e9;

     for (int num : nums) {
        mn = Math.min(mn, getSum(num));
     }

     return mn;
    }

    private int getSum(int num) {
        int cur = 0;

        while (num > 0) {
            cur += (num % 10);
            num /= 10;
        }
        return cur;
    }
}

/*

9, 100, 999, 9999




*/