class Solution {
    public String convert(String s, int numRows) {
        
        if (numRows == 1 || numRows >= s.length()) return s;

        int n = s.length();

        List<StringBuilder> rows = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }

        int i = 0, step = 1;

        for (int j = 0; j < n; j++) {
            char ch = s.charAt(j);

            rows.get(i).append(ch);

            i += step;

            if (i == 0 || i == numRows - 1) step = -step;
        }

        StringBuilder sb = new StringBuilder();
        for (StringBuilder cur : rows) {
            sb.append(cur);
        }

        return sb.toString();
    }
}