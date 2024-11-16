class Solution {
    private TrieNode root;
    private List<String> result;
    private boolean[][] visited;
    
    public List<String> findWords(char[][] board, String[] words) {
        root = new TrieNode();
        result = new ArrayList<>();
        
        for (String word : words) {
            addWord(word);
        }
        
        int rows = board.length;
        int cols = board[0].length;
        visited = new boolean[rows][cols];
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                dfs(board, i, j, root);
            }
        }
        
        return result;
    }
    
    private void dfs(char[][] board, int i, int j, TrieNode node) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j]) {
            return;
        }
        
        char c = board[i][j];
        TrieNode nextNode = node.children[c - 'a'];
        if (nextNode == null) return;
        
        visited[i][j] = true;
        if (nextNode.word != null) {
            result.add(nextNode.word);
            nextNode.word = null; 
        }
        
        dfs(board, i + 1, j, nextNode);
        dfs(board, i - 1, j, nextNode);
        dfs(board, i, j + 1, nextNode);
        dfs(board, i, j - 1, nextNode);
        
        visited[i][j] = false;
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
        TrieNode[] children = new TrieNode[26];
        String word; 
    }
}
