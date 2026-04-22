#include <string>
#include <vector>

using namespace std;

class Solution {
public:
    string intToRoman(int num) {
        vector<string> r = {
            "M", "CM", "D", "CD", "C", "XC", "L",
            "XL", "X", "IX", "V", "IV", "I"
        };

        vector<int> in = {
            1000, 900, 500, 400, 100, 90,
            50, 40, 10, 9, 5, 4, 1
        };

        int n = r.size();
        string result;
        int curNum = num;

        for (int i = 0; i < n && curNum > 0; i++) {

            while (in[i] <= curNum) {
                curNum -= in[i];
                result += r[i];
            }

        }

        return result;
    }
};

/**




{ "M",  "CM", "D",  "CD", "C",  "XC", "L", "XL",  "X", "IX", "V", "IV", "I" };
{ 1000, 900,  500,  400,  100,   90,   50,  40,   10,   9,    5,   4,    1 };


input: 3749

curNum : 0

ouput: MMMDCCXLIX



*/