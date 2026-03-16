class Solution {
    public String convert(String s, int numRows) {
        if (numRows >= s.length() || numRows == 1) return s;
        int step = 1, row = 0;
        StringBuilder[] arr = new StringBuilder[numRows];

        for (int i = 0; i < numRows; i++) arr[i] = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            arr[row].append(s.charAt(i));

            row += step;
            
            if (row == 0 || row == numRows - 1) step = -step;
        }

        StringBuilder res = new StringBuilder();

        for (StringBuilder sb : arr) {
            res.append(sb);
        } 

        return res.toString();
    }
}