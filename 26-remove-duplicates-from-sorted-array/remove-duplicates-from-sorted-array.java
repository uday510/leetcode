class Solution {
    public int removeDuplicates(int[] arr) {
        int idx = 1, cnt = 1;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1]) {
                cnt++;
            } else {
                cnt = 1;
            }

            if (cnt == 1) {
                arr[idx++] = arr[i];
            }
        }

        return idx;
    }
}