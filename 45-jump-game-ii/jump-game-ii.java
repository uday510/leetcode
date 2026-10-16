class Solution {
    public int jump(int[] arr) {
        
        int steps = 0, lastJumpPos = 0, maxJump = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            maxJump = Math.max(i + arr[i], maxJump);

            if (lastJumpPos == i) {
                steps++;
                lastJumpPos = maxJump;
            }
        }

        return steps;
    }
}