#include <vector>
#include <unordered_set>
using namespace std;

class Solution {
public:
    bool isValidSudoku(vector<vector<char>>& board) {
        
        int n = 9;
        vector<unordered_set<char>> rows(9);
        vector<unordered_set<char>> cols(9);
        vector<unordered_set<char>> boxes(9);

        for (int r = 0; r < n; r++) {

            for (int c = 0; c < n; c++) {

                char ch = board[r][c];

                if (ch == '.') continue; // empty


                int boxId = ((r / 3) * 3) + (c / 3);

                if (
                    rows[r].count(ch) || 
                    cols[c].count(ch) || 
                    boxes[boxId].count(ch)
                ) {
                    return false;
                }

                rows[r].insert(ch);
                cols[c].insert(ch);
                boxes[boxId].insert(ch);
            }
        }

        return true;
    }
};