class Solution {
    public int candy(int[] r) {
        int n = r.length;
        int[] arr = new int[n];

        arr[0] = 1;
        for (int i = 1; i < n; i++) {
            if (r[i] > r[i - 1]) arr[i] = arr[i - 1] + 1;
            else arr[i] = 1;
        }

        int sum = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (r[i] > r[i + 1]) {
                arr[i] = Math.max(arr[i], arr[i + 1] + 1);
            }
            sum += arr[i];
        }

        return sum;
    }
}
