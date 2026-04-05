class Solution {

    private static Set<Character> pos = new HashSet<>();
    static { pos.add('U'); pos.add('D'); }

    public boolean judgeCircle(String moves) {
        int x = 0, y = 0;

        for (int i = 0; i < moves.length(); i++) {
            char move = moves.charAt(i);

            if (pos.contains(move)) 
                x += getCnt(move);
            else y += getCnt(move);

        }

        return x == 0 && y == 0;
    }

    private int getCnt(char dir) {
        return dir == 'U' || dir == 'R' ? 1 : -1;
    }
}