class Solution {
private:
    vector<vector<int>> DIRs = { {0,1}, {1,0}, {-1,0}, {0,-1} };

public:
    int orangesRotting(vector<vector<int>>& grid) {
        
        int numRows = grid.size();
        int numCols = grid[0].size();

        vector<vector<bool>> vis(numRows, vector<bool>(numCols, false));

        queue<pair<int, int>> queue;

        int fresh = 0;

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {

                if (grid[i][j] == 2) { // rotten
                    queue.push({i, j});
                    vis[i][j] = true;
                } 

                if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        if (fresh == 0) return 0;

        int mins = -1;

        while (!queue.empty()) {
            
            mins++;
            int sz = queue.size();

            for (int i = 0; i < sz; i++) {
                auto cur = queue.front();
                queue.pop();

                int x = cur.first, y = cur.second;

                for (auto& dir : DIRs) {
                    int nx = dir[0] + x; // new row
                    int ny = dir[1] + y; // new col

                    if (
                        nx < 0 || nx >= numRows ||  // out of bounds
                        ny < 0 || ny >= numCols || // // out of bounds
                        vis[nx][ny]  // visited
                        || grid[nx][ny] != 1 // not fresh
                        ) {

                        continue;
                    }

                    fresh--;
                    vis[nx][ny] = true;
                    queue.push({nx, ny});

                }

            }
 
        }

        if (fresh != 0) return -1;

        return mins;
    }
};