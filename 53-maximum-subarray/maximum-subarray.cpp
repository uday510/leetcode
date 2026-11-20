class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        int mx = INT_MIN;
        int cur = 0;

        for (int num : nums) {
            cur = max(num, cur + num);
            mx = max(mx, cur);
        }

        return mx;
    }
    
};


/**


cur = 0
mx = int_min

5,  4,  -1, 7,  8

cur = max(nums[i], cur + nums[i])
mx = max(mx, cur)

mx = int_min
cur = 0
[5, -14]

cur = max(5, 0 + 5) = 5

cur = max(reset_subarray, extend_subarray)

reset_subarray = start from current index (take current element nums[i])
extend_subarray = take current index into previous subarray


cur = 0
mx = int_min
[1, 2, 3]

cur = max(1, 0 + 1) = 1
mx = max(cur, mx) = 1


---- 
cur = max(2, 1 + 2) = 3
mx = max(1, 3) = 3

-----

cur = max(3, 2 + 3) = 5
mx = max(3, 5) = 5

result = 5

------------

[-14, -10, -2, 30, 40]

cur = 0
mx = int_min

cur = max(-14, 0 - 14) = -14
mx = max(int_min, -14) = -14


cur = max(-10, -14 - 10) = -10
mx = max(-14, -10) = -10

cur = max(-2, -10 - 2) = -2
mx = max(-10, -2) = -2

cur = max(30, -2 + 30) = 30
mx = max(-2, 30) = 30

cur = max(40, 30 + 40) = 70
mx = max(30, 70) = 70

result = 70








*/