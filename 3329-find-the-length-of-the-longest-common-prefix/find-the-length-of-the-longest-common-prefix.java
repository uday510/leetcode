class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Trie root = new Trie();
        for (int num : arr1)
            insert(root, String.valueOf(num));

        int longest = 0;
        for (int num : arr2) 
            longest = Math.max(longest, search(root, String.valueOf(num)));

        return longest;
    }

    private void insert(Trie trie, String str) {
        for (int i = 0; i < str.length(); ++i) {
            int idx = getIdx(str, i);
            if (child(trie, idx) == null)   
                trie.children[idx] = new Trie();
            
            trie = child(trie, idx);
        }
    }

    private int search(Trie trie, String str) {
        int count = 0;
        for (int i = 0; i < str.length(); ++i) {
            int idx = getIdx(str, i);
            if (child(trie, idx) == null)
                return count;
            ++count;
            trie = child(trie, idx);
        }
        return count;
    }

    private int getIdx(String str, int i) {
        return str.charAt(i) - '0';
    }

    private Trie child(Trie trie, int i) {
        return trie.children[i];
    }

}

class Trie {
    Trie[] children;
    public Trie() {
        children = new Trie[10];
    }
}