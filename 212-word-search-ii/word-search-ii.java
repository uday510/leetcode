class Solution {
    TrieNode root;
    List<String> res;
    boolean[][] vis;
    int m;
    int n;
    public List<String> findWords(char[][] board, String[] words) {
        root = new TrieNode();
        res = new ArrayList<>();
        m = board.length;
        n = board[0].length;
        vis = new boolean[m][n];

        for (String word : words) {
            addWord(word);
        }

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                dfs(i, j, board, root);
            }
        }

        return res;
    }
    private void dfs(int i, int j, char[][] board, TrieNode node) {
        if (i < 0 || i >= m || j < 0 || j >= n || node == null || vis[i][j]) {
            return;
        }

        int index = board[i][j] - 'a';
        node = node.children[index];

        if (node == null) {
            return;
        }

        vis[i][j] = true;

        if (node.word != null) {
            res.add(node.word);
            node.word = null;
        }

        dfs(i + 1, j, board, node);
        dfs(i - 1, j, board, node);
        dfs(i, j - 1, board, node);
        dfs(i, j + 1, board, node);

        vis[i][j] = false;
    }
    private void addWord(String word) {
        TrieNode currNode = root;

        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (currNode.children[index] == null) {
                currNode.children[index] = new TrieNode();
            }

            currNode = currNode.children[index];
        }

        currNode.word = word;
    }
    private class TrieNode {
        String word;
        TrieNode[] children = new TrieNode[26];
    }
}