class Solution {
    public boolean isPathCrossing(String path) {
        Set<Integer> vis = new HashSet<>();
        int x = 0; int y = 0;
        vis.add(0);
        for (char dir : path.toCharArray()) {
            if (dir == 'N') --x;
            else if (dir == 'E') ++y;
            else if (dir == 'S') ++x;
            else if (dir == 'W') --y;
            
            int pos = (x*1000) + y;
            if (vis.contains(pos)) return true;
            vis.add(pos);
        }
        return false;
    }
}