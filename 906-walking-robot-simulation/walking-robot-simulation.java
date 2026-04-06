class Solution {

    private static final int[][] DIRs = { {0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int robotSim(int[] cmds, int[][] obs) {

        Set<Long> ob = new HashSet<>();
        for (int[] o : obs) {
            ob.add(getKey(o[0], o[1]));
        }

        int[] pos = {0, 0};
        int mx = 0, curDir = 0;

        for (int c : cmds) {
            if (c == -1) {
                curDir = (curDir + 1) % 4;
            } else if (c == -2) {
                curDir = (curDir + 3) % 4;
            } else {
                int[] dir = DIRs[curDir];
                for (int i = 0; i < c; i++) {
                    int x = pos[0] + dir[0];
                    int y = pos[1] + dir[1];

                    if (ob.contains(getKey(x, y))) {
                        break;
                    }

                    pos[0] = x;
                    pos[1] = y;
                }
            }

            mx = Math.max(mx, pos[0] * pos[0] + pos[1] * pos[1]);
        }

        return mx;

    }

    private long getKey(int x, int y) {
        return (((long)x) << 32) | (y & 0xffffffffL);
    }
}


/**

    |
 -- * --
    |

 */