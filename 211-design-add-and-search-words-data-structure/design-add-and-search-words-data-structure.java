class WordDictionary {
    TrieNode root;
    public WordDictionary() {
        root = new TrieNode('$');
    }
    
    public void addWord(String word) {
        TrieNode currNode = root;

        for (char c : word.toCharArray()) {
            int index = c - 'a';

            if (currNode.children[index] == null) {
                currNode.children[index] = new TrieNode(c);
            }

            currNode = currNode.children[index];
            currNode.freq++;
        }
        currNode.eow = true;
    }
    
    public boolean search(String word) {
        return dfs(word, 0, root);
    }
    private boolean dfs(String word, int index, TrieNode node) {
        if (node == null) {
            return false;
        }
        if (index == word.length()) {
            return node.eow;
        }

        char c = word.charAt(index);
        
        if (c == '.') {
            for (int i = 0; i < 26; ++i) {
                if (dfs(word, index + 1, node.children[i])) {
                    return true;
                }
            }
            return false;
        }
        
        return dfs(word, index + 1, node.children[c - 'a']);
    }
    private class TrieNode {
        char data;
        TrieNode[] children;
        boolean eow;
        int freq;

        TrieNode(char data) {
            this.data = data;
            children = new TrieNode[26];
            eow = false;
            freq = 0;
        }
    }
}


