class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] count = new int[1001];

        for (int i : arr1) {
            count[i]++;
        }

        int index = 0;

        for (int i : arr2) {
            while (count[i] > 0) {
                arr1[index++] = i;
                count[i]--;
            }
        }

        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                arr1[index++] = i;
                count[i]--;
            }
        }
        return arr1;
    }
}