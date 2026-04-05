class Solution {

    private static final Map<Character, int[]> map = Map.of(
        'U', new int[] {1, 0},
        'D', new int[] {-1, 0},
        'R', new int[] {0, 1},
        'L', new int[] {0, -1}
    );
    
    public boolean judgeCircle(String moves) {
        int x = 0, y = 0;

        for (int idx = 0; idx < moves.length(); idx++) {
            int[] m = map.get(moves.charAt(idx));
            x += m[0];
            y += m[1];
        }

        return x == 0 && y == 0;
    }
}