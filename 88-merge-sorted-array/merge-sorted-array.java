class Solution {
    public void merge(int[] arr1, int m, int[] arr2, int n) {
        int i = m - 1, j = n - 1, k = arr1.length - 1;

        while (i > -1 && j > -1) {
            if (arr2[j] > arr1[i]) {
                arr1[k--] = arr2[j--];
            } else {
                arr1[k--] = arr1[i--];
            }
        }


        while (i > -1) arr1[k--] = arr1[i--];
        while (j > -1) arr1[k--] = arr2[j--];
    }
}