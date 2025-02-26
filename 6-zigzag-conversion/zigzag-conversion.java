class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1 || numRows >= s.length()) {
            return s;
        }
        var rows = new ArrayList<StringBuilder>();

        for (int i = 0; i < numRows; ++i) {
            rows.add(new StringBuilder());
        }
        int currRow = 0;
        int step = 1;

        for (char c : s.toCharArray()) {
            rows.get(currRow).append(c);

            currRow += step;

            if (currRow == 0 || currRow == numRows - 1) {
                step = -step;
            }
        }

        StringBuilder res = new StringBuilder();

        for (var row : rows) {
            res.append(row);
        }
        return res.toString();
    }
}