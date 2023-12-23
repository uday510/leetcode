public class Solution {
    public boolean isPathCrossing(String path) {
        Set<Integer> vis = new HashSet<>();
        int x = 0, y = 0;
        vis.add(0);

        for (char direction : path.toCharArray()) {
            if (direction == 'N') x--;
            else if (direction == 'E') y++;
            else if (direction == 'S') x++;
            else if (direction == 'W') y--;

            int pos = x *1000 +  y;

            if (vis.contains(pos)) return true;
            vis.add(pos);
        }
        
        return false;
    }
}
