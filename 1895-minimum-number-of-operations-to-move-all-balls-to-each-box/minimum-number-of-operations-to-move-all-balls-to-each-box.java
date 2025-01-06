class Solution {
    public int[] minOperations(String boxes) {
        int len = boxes.length();
        int[] result = new int[len];
        int balls = 0;
        int ops = 0;

        for (int idx = 0; idx < len; ++idx) {
            result[idx] += ops;

            balls += isBall(boxes, idx) ? 1 : 0;
            ops += balls;
        }

        balls = 0;
        ops = 0;

        for (int idx = len - 1; idx > -1; --idx) {
            result[idx] += ops;

            balls += isBall(boxes, idx) ? 1 : 0;
            ops += balls;
        }

        return result;
    }

    private boolean isBall(String str, int index) {
        return str.charAt(index) == '1';
    }
}