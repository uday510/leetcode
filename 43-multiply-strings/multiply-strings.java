import java.math.BigInteger;
class Solution {
    public String multiply(String num1, String num2) {
        BigInteger t1 = new BigInteger(num1);
        BigInteger t2 = new BigInteger(num2);
        BigInteger t3 = t1.multiply(t2);

        return t3.toString();
    }
}