class Solution {
    public int calculate(String s) {
        int n = s.length();
        int currNum = 0;
        int lastNum = 0;
        int result = 0;
        char operation = '+';

        for (int i = 0; i < n; ++i) {
            char currChar = s.charAt(i);

            if (Character.isDigit(currChar)) {
                currNum = (currNum * 10) + (currChar - '0');
            }

            if (!Character.isDigit(currChar) && !Character.isWhitespace(currChar) || i == n - 1) {
                if (operation == '+' || operation == '-') {
                    result += lastNum;
                    lastNum = (operation == '+') ? currNum : -currNum;
                } else if (operation == '*') {
                   lastNum = lastNum * currNum;
                } else if (operation == '/') {
                    lastNum = lastNum / currNum;
                }
                currNum = 0;
                operation = currChar;
            }
        }
        result += lastNum;
        return result;
    }
}