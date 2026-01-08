class Solution {
    public void rotate(int[][] A) {
        
        transpose(A);
        reverse(A);
    }

    private void transpose(int[][] A) {
        int n = A.length;
        int m = A[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < m; j++) {

                int tmp = A[i][j];
                A[i][j] = A[j][i];
                A[j][i] = tmp;

            }
        }
    }

    private void reverse(int[][] A) {
        for (int[] row : A) {
            reverse(row);
        }
    }

    private void reverse(int[] A) {
        int l = 0, r = A.length - 1;

        while (l < r) {
            swap(l++, r--, A);
        }
    }

    private void swap(int i, int j, int[] arr) {
        int tmp = arr[j];
        arr[j] = arr[i];
        arr[i] = tmp;
    }

}