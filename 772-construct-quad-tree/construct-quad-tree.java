/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}
*/

class Solution {
    public Node construct(int[][] grid) {
        return dfs(0, 0, grid.length, grid);
    }

    private Node dfs(int x, int y, int n, int[][] grid) {
        if (n == 1) {
            return new Node(grid[x][y] == 1, true, null, null, null, null);
        }

        int N = n / 2;
        Node tl = dfs(x, y, N, grid);
        Node tr = dfs(x, y + N, N, grid);
        Node bl = dfs(x + N, y, N, grid);
        Node br = dfs(x + N, y + N, N, grid);

        if (isLeaf(tl, tr, bl, br)) {
            return new Node(tl.val, true, null, null, null, null);
        }

        return new Node(tl.val, false, tl, tr, bl, br);

    }

    private boolean isLeaf(
        Node tl,
        Node tr,
        Node bl,
        Node br
    ) {
        return (
               tl.isLeaf && tr.isLeaf &&
               bl.isLeaf && br.isLeaf &&
               tl.val == tr.val && 
               tr.val == bl.val &&
               bl.val == br.val
            );
    }
}