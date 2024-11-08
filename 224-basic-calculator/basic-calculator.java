import java.util.Stack;

class Solution {
    public int calculate(String s) {
        int currentNumber = 0;
        int lastNumber = 0;
        int result = 0;
        char lastOperator = '+';
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);

            if (Character.isDigit(currentChar)) {
                currentNumber = (currentNumber * 10) + (currentChar - '0');
            }

            if (!Character.isDigit(currentChar) && !Character.isWhitespace(currentChar) || i == s.length() - 1) {

                if (lastOperator == '+') {
                    result += lastNumber;
                    lastNumber = currentNumber;
                } else if (lastOperator == '-') {
                    result += lastNumber;
                    lastNumber = -currentNumber;
                } else if (lastOperator == '*') {
                    lastNumber *= currentNumber;
                } else if (lastOperator == '/') {
                    lastNumber /= currentNumber;
                }

                if (currentChar == '(') {
                    stack.push(result);
                    stack.push((int) lastOperator);
                    result = 0;
                    lastNumber = 0;
                    lastOperator = '+';
                } 

                else if (currentChar == ')') {
                    result += lastNumber;

                    lastOperator = (char) stack.pop().intValue();
                    int previousResult = stack.pop();
                    
                    if (lastOperator == '+') {
                        result = previousResult + result;
                    } else if (lastOperator == '-') {
                        result = previousResult - result;
                    }
                    
                    lastNumber = 0;
                } else {
                    lastOperator = currentChar;
                }

                currentNumber = 0;
            }
        }

        result += lastNumber;

        return result;
    }
}
