class Solution {
    public int minNumberOperations(int[] arr) {
        int ops = 0;
        ops += arr[0];

        for (int i = 1; i < arr.length; i++) {
            ops += Math.max(arr[i] - arr[i - 1], 0);
        }

        return ops;
    }
}

/**

1 2 3

1 < 7

1 0 0


 */