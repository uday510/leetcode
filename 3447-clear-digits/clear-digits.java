class Solution {
    public String clearDigits(String s) {
        
        StringBuilder sb = new StringBuilder();

        for (char ch : s.toCharArray()) {
            
            if (ch <= '9' && ch >= '0') {
                if (sb.length() != 0) 
                    sb.deleteCharAt(sb.length() - 1);
            } else {
                sb.append(ch);
            }
        }

        return sb.toString();
    }
}