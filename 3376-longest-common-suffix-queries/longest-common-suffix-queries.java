class Solution {

    private int shortest;
    private int shortestLen; 
    private Trie root;

    public int[] stringIndices(String[] words, String[] q) {
        root = new Trie();
        shortest = -1;
        shortestLen = Integer.MAX_VALUE; 

        insert(words, root);

        int n = q.length;
        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            res[i] = find(q[i].length() - 1, q[i], root);
            res[i] = res[i] == -1 ? shortest : res[i];

            System.out.println(res[i]);
        }


        return res;
    }

    private int find(int i, String s, Trie node) {
        if (node == null) {
            return -1;
        }

        if (i < 0) {
            return node.idx;
        }

        int index = s.charAt(i) - 'a';

        if (node.child[index] == null) {
            return node == root ? -1 : node.idx;
        }

        return find(i - 1, s, node.child[index]);
    }

    private void insert(String[] strs, Trie root) {
        Trie cur = root;

        for (int i = 0; i < strs.length; i++) {
            
            String s = strs[i];

            for (int j = s.length() - 1; j > -1; j--) {
                int index = s.charAt(j) - 'a';

                if (cur.child[index] == null) {
                    cur.child[index] = new Trie();
                }

                cur = cur.child[index];
                if (s.length() < cur.len) {
                    cur.idx = i;
                    cur.len = s.length();
                }
                
            }

            if (s.length() < shortestLen) {
                shortestLen = s.length();
                shortest = i;
            }

            cur = root;
        }
        
    }   
}

class Trie {

    int idx;
    int len;
    Trie[] child;

    Trie () {
        child = new Trie[26];
        idx = Integer.MAX_VALUE;
        len = Integer.MAX_VALUE;
    }
}