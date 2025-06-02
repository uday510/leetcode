class Solution {
    public int climbStairs(int n) {
        int climb0 = 0, climb1 = 1;

        for (int i = 1; i <= n; ++i) {
            int climb2 = climb0 + climb1;
            climb0 = climb1;
            climb1 = climb2;
        }

        return climb1;
    }
}