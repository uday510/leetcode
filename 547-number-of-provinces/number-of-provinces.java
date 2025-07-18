class Solution {

    int[][] arr;
    int[] vis;

    public int findCircleNum(int[][] arr) {
        vis = new int[arr.length];
        this.arr = arr;
        int cnt = 0;

        for (int city = 0; city < arr.length; ++city) {
            if (vis[city] == 0) {
                System.out.println(city + 1);
                cnt++;
                dfs(city);
            }
        }

        return cnt;
    }

    private void dfs(int i) {
        if (vis[i] == 1) return;

        vis[i] = 1;
        for (int j = 0; j < arr[i].length; ++j) {
            if (arr[i][j] == 1) {
                System.out.println(i + " -> " + j);
                dfs(j);
            }
        }
    }
}