public class Solution {
    public boolean isPathCrossing(String path) {
        Set<String> vis = new HashSet<>();
        int x = 0, y = 0;
        vis.add("0-0");

        for (char direction : path.toCharArray()) {
            if (direction == 'N') x--;
            else if (direction == 'E') y++;
            else if (direction == 'S') x++;
            else if (direction == 'W') y--;

            String pos = x + "-" + y;

            if (vis.contains(pos)) return true;
            vis.add(pos);
        }

        return false;
    }
}
