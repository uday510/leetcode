class Solution {
    public boolean isRobotBounded(String in) {
        int x = 0, y = 0, idx = 0, dirs[][] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        for (int i = 0; i < in.length(); i++) {
            char ch = in.charAt(i);

            if (ch == 'R') idx = (idx + 1) % 4;
            else if (ch == 'L') idx = (idx + 3) % 4;
            else {
                x += dirs[idx][0];
                y += dirs[idx][1];
            }
        }

        return x == 0 && y == 0 || idx != 0;
    }
}





