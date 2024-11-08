class Solution {
    public int calculate(String s) {
        int n = s.length();
        int currentNumber = 0;
        int lastNumber = 0;
        int result = 0;
        char lastOperator = '+';

        for (int i = 0;i < n; ++i) {
            char currentChar = s.charAt(i);

            if (Character.isDigit(currentChar)) {
                currentNumber = (currentNumber * 10) + (currentChar - '0');
            }

            if (!Character.isDigit(currentChar) && !Character.isWhitespace(currentChar) || i == n-1) {

                if (lastOperator == '+' || lastOperator == '-') {
                    result += lastNumber;
                    lastNumber = (lastOperator == '+') ? currentNumber : -currentNumber;
                } else if (lastOperator == '*') {
                    lastNumber = (lastNumber * currentNumber);
                } else if (lastOperator == '/') {
                    lastNumber = (lastNumber / currentNumber);
                }

                currentNumber = 0;
                lastOperator = currentChar;
            }
        }

        result += lastNumber;

        return result;
    }
}