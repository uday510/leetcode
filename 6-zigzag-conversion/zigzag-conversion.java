class Solution {
    public String convert(String s, int numRows) {
        if (numRows >= s.length() || numRows == 1) 
            return s;
        
        int step = 1, r = 0;
        StringBuilder[] rows = new StringBuilder[numRows];

        for (int i = 0; i < numRows; i++) 
            rows[i] = new StringBuilder();

        
        for (int i = 0; i < s.length(); i++) {
            rows[r].append(s.charAt(i));

            r += step;

            if (r == 0 || r == numRows - 1)
                step = -step;
        }

        StringBuilder res = new StringBuilder();
        for (StringBuilder sb : rows) {
            res.append(sb);
        }

        return res.toString();
    }
}