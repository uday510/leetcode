class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        Queue<int[]> queue = new ArrayDeque<>();
        int pc = image[sr][sc];
        queue.offer(new int[]{sr, sc});
        image[sr][sc] = color;

        int N = image.length, M = image[0].length;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int[] dir : dirs) {
                int R = cur[0] + dir[0], C = cur[1] + dir[1];

                if (R < 0 || R >= N || C < 0 || C >= M || image[R][C] == color || image[R][C] != pc) continue;
                image[R][C] = color;
                System.out.println(R + " " + C);
                queue.offer(new int[]{R, C});
            }
        }

        return image;
    }
}