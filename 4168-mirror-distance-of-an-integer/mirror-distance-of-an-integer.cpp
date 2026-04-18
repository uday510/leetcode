class Solution {
public:

    int reverse(int n) {
        int cur = n;
        int ans = 0;

        while (cur > 0) {
            ans = (ans * 10) + (cur % 10);
            cur = cur / 10;
        }

        return ans;
    }

    int mirrorDistance(int n) {
        return abs(n - reverse(n));
    }
    
};



/**

194 -> 491

cur = 194
ans = 0

to get last bit value -> use mod by 10 (%)
to remove last bit value -> use divide by 10

ans = (ans * 10) + (cur % 10)
    = (0 * 10) + (194 % 10) = 0 + 4 = 4

cur = 194 / 10 = 19

ans = 4
cur = 19

ans = (4 * 10) + (19 % 10) = 40 + 9 = 49 
cur = cur / 10 = 1

ans = (49 * 10) + (1 % 10) = 490 + 1 = 491
cur = cur / 10 = 0









**/