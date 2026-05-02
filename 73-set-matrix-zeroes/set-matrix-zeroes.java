class Solution {
    public void setZeroes(int[][] arr) {
        
        int n = arr.length, m = arr[0].length;
        boolean isCol0 = false;

        // step: 1
        for (int i = 0; i < n; i++) {
            if (arr[i][0] == 0) isCol0 = true;
            for (int j = 1; j < m; j++) {
                if (arr[i][j] == 0) {
                    arr[i][0] = arr[0][j] = 0;
                }
            }

        }

        // step: 2

        for (int i = 1; i < n; i++) {

            for (int j = 1; j < m; j++) {
               
               if ( arr[i][0] == 0 || arr[0][j] == 0) {
                    arr[i][j] = 0;
               }
            }
        }

        // step 3:  handle first row
        if (arr[0][0] == 0) {
            for (int j = 0; j < m; j++) arr[0][j] = 0;
        }

        // step4: handle first col
        if (isCol0) {
            for (int i = 0; i < n; i++) arr[i][0] = 0;
        }

    }
}