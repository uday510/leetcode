class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int n = grid.length, m = grid[0].length;

        List<Node> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                list.add(new Node(grid[i][j], i, j));
            }
        }

        for (int i = 1; i <= k; i++) {
            move(list, n, m);
        }

        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            res.add(new ArrayList<>(Collections.nCopies(m, null)));
        }

        for (Node cur : list) {
            int x = cur.x, y = cur.y;
            res.get(cur.x).set(y, cur.k);
        }

        return res;
    }

    private void move(List<Node> list, int n, int m) {
        
        for (Node cur : list) {
            int dx = cur.x;
            int dy = cur.y;

            int nx = dx;
            int ny = (dy + 1) % m;           

            if (ny == 0) {
                if (nx == n - 1) {
                    nx = 0;
                } else {
                    nx = nx + 1;
                }
            }

            cur.x = nx;
            cur.y = ny;
        } 
    }
}

class Node {
    int k, x, y;

    Node (int k, int x, int y) {
        this.k = k;
        this.x = x;
        this.y = y;
    }
}

/**


   0   1   2
0  1   2   3       
1  4   5   6
2  7   8   9   

k = 1
   0   1   2
0  9   1   3       
1  3   4   5 
2  6   7   8   


 */