class Solution {
    public boolean validWordSquare(List<String> words) {
        int n = words.size();
        for (int i = 0; i < n; i++) {
            String w = words.get(i);
            int m = w.length();

            for (int j = 0; j < m; j++) {

                if (j >= n || i >= words.get(j).length() ||
                    w.charAt(j) != words.get(j).charAt(i)
                ) return false;
            }
        }

        return true;
    }
}