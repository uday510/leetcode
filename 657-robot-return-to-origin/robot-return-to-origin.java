class Solution {

    private static Map<Character, Integer> xMap = new HashMap<>();
    private static Map<Character, Integer> yMap = new HashMap<>();

    static {
        xMap.put('U', 1);
        xMap.put('D', -1);

        yMap.put('R', 1);
        yMap.put('L', -1);
    }

    
    public boolean judgeCircle(String moves) {
        int x = 0, y = 0;

        for (int i = 0; i < moves.length(); i++) {
            char move = moves.charAt(i);

            if (xMap.containsKey(move)) 
                x += xMap.get(move);
            else 
                y += yMap.get(move);

        }

        return x == 0 && y == 0;
    }

}