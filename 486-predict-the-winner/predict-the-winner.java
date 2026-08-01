class Solution {
    public boolean predictTheWinner(int[] arr) {
        return dfs(0, arr.length - 1, arr) > -1;
    }

    private int dfs(int l, int r, int[] arr) {
        if (l == r) return arr[l];

        int t1 = arr[l] - dfs(l + 1, r, arr);
        int t2 = arr[r] - dfs(l, r - 1, arr);

        return Math.max(t1, t2);
    }
}

/**

 
              9 1 2 5
            9        5
       2   [1 2 5]   [9 1 2]
            1.   5 
        3  [2 5] [1 2] 1
            2  5   1  2
           [5] [2] [2] [1]

 */        

 