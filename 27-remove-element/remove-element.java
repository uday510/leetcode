class Solution {
    public int removeElement(int[] arr, int val) {
        int idx = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != val) {
                arr[idx++] = arr[i];
            }
        }

        return idx;
    }
}