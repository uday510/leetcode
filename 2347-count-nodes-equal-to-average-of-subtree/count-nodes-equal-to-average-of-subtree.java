class Solution {
    int avgCnt;
    class State {
        int nodeCnt;
        int nodeSum;

        State(int nodeSum, int nodeCnt) {
            this.nodeSum = nodeSum;
            this.nodeCnt = nodeCnt;
        }
    }
    public int averageOfSubtree(TreeNode root) {
        avgCnt = 0;
        dfs(root);
        return avgCnt;
    }
    public State dfs(TreeNode node) {
        if (node == null) return new State(0, 0);

        State left = dfs(node.left);
        State right = dfs(node.right);

        int currSum = left.nodeSum + right.nodeSum + node.val;
        int nodeCnt = left.nodeCnt + right.nodeCnt + 1;

        if (node.val == (currSum/nodeCnt)) {
            System.out.println(node.val);
            avgCnt++;
        }

        return new State(currSum, nodeCnt);
    }
}