class Solution {
    public int numOfSubarrays(int[] arr) {
        final int mod = 1_000_000_007;
        int even = 1, odd = 0;
        int sum = 0;
        long res = 0;

        for (int a : arr) {
            sum += a;

            if ((sum & 1) == 1) {
                res += even;
                odd++;
            } else {
                res += odd;
                even++;
            }
        }

        return (int) (res % mod);
    }
}