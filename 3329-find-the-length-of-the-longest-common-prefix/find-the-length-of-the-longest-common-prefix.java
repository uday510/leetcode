class Solution {

    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Trie root = new Trie();
        
        for (int num : arr1) {
            insert(root, String.valueOf(num));
        }

        int longest = 0;
        for (int num : arr2) {
            longest = Math.max(longest, getCommonPrefix(root, String.valueOf(num)));
        }

        return longest;
    }

    private void insert(Trie root, String s) {
        Trie cur = root;
        System.out.println(cur);


        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - '0';

            if (cur.children[idx] == null) {
                cur.children[idx] = new Trie();
            }

            cur = cur.children[idx];
        }   
    }

    private int getCommonPrefix(Trie root, String s) {
        int cnt = 0;
        Trie cur = root;

        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - '0';
            Trie child = cur.children[idx];
            if (child == null) return cnt;
            cnt++;
            cur = child;
        }

        return cnt;
    }

}


class Trie {
    Trie[] children;

    public Trie() {
        children = new Trie[10];
    }

}