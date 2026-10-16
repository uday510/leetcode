class Solution {
    public int majorityElement(int[] arr) {
        int major = arr[0], cnt = 0;

        for (int a : arr) {
            if (a == major) cnt++;
            else cnt--;

            if (cnt == 0) {
                major = a;
                cnt = 1;
            }
        }

        return major;
    }
}