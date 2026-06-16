

class Solution {
    
    private static final Map<Character, Consumer<StringBuilder>> OPS = Map.of(
            '#', sb -> sb.append(sb),
            '%', sb -> sb.reverse(),
            '*', sb -> { if (sb.length() > 0) sb.deleteCharAt(sb.length() - 1); }
    );
    
    public String processStr(String s) {
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 'a' && c <= 'z') sb.append(c);
            else OPS.get(c).accept(sb);
        }
        
        return sb.toString();
    }
}