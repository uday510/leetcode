class Solution {
    public void rotate(int[][] arr) {
        
        int n = arr.length, m = arr[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < m; j++) {
                
                int tmp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = tmp;
            }
        }

        for (int[] row : arr) {
            reverse(row);
        }
    }

    private void reverse(int[] arr) {

        int i = 0, j = arr.length - 1;

        while (i < j) {
            swap(i, j, arr);
            i++; j--;
        }
    }

    private void swap(int i, int j, int[] arr) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
