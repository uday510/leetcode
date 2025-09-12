class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";

        StringBuilder sb = new StringBuilder();

        if ( (numerator < 0 && denominator > 0) || (denominator < 0 && numerator > 0)) {
            sb.append("-");
        }

        long nume = Math.abs(Long.valueOf(numerator));
        long deno = Math.abs(Long.valueOf(denominator));

        sb.append(String.valueOf(nume / deno));

        long rem = nume % deno;

        if (rem == 0) return sb.toString();

        sb.append(".");

        Map<Long, Integer> map = new HashMap<>();

        while (rem != 0) {
            if (map.containsKey(rem)) {
                int posToInsertOpenBracket = map.get(rem);
                sb.insert(posToInsertOpenBracket, "(");
                sb.append(")");
                break;
            } else {
                map.put(rem, sb.length());
                rem *= 10l;
                sb.append(rem / deno);
                rem %= deno;
            }
        }

        return sb.toString();
    }
}