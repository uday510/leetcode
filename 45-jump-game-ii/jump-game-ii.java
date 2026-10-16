class Solution {
    public int jump(int[] arr) {
        
        int steps = 0, lastPos = 0, farthest = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            farthest = Math.max(farthest, i + arr[i]);

            if (i == lastPos) {
                lastPos = farthest;
                steps++;
            }
        }

        return steps;
    }
}