class Trie {
    private TrieNode root;
    public Trie() {
        root = new TrieNode('R');
    }
    
    public void insert(String word) {
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
        TrieNode currNode = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (currNode.children[index] == null) {
                return false;
            }
            currNode = currNode.children[index];
        }

        return currNode.eow;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode currNode = root;
        for (char c : prefix.toCharArray()) {
            int index = c - 'a';
            if (currNode.children[index] == null) {
               return false;
            }
            currNode = currNode.children[index];
        }

       return currNode.freq > 0;
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

