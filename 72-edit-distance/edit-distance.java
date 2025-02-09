class Solution {

    String word1;
    String word2;
    int length1;
    int length2;
    Integer[][] memo;

    public int minDistance(String word1, String word2) {
        initialize(word1, word2);

        return dfs(0, 0);
    }

    private int dfs(int index1, int index2) {
        if (index1 == length1) {
            return length2 - index2;
        } 

        if (index2 == length2) {
            return length1 - index1;
        }

        if (memo[index1][index2] != null) {
            return memo[index1][index2];
        }

        if (word1.charAt(index1) == word2.charAt(index2)) {
            memo[index1][index2] = dfs(index1 + 1, index2 + 1);
        } else {
            int insert = dfs(index1, index2 + 1) + 1;
            int delete = dfs(index1 + 1, index2) + 1;
            int replace = dfs(index1 + 1, index2 + 1) + 1;

            memo[index1][index2] = Math.min(insert, Math.min(delete, replace));
        }

        return memo[index1][index2];
    }

    private void initialize(String word1, String word2) {
        this.word1 = word1;
        this.word2 = word2;
        length1 = word1.length();
        length2 = word2.length();
        memo = new Integer[length1][length2];
    }
}