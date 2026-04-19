class Solution {
public:
    int search(vector<int>& nums, int target) {
        
        int left = 0, right = nums.size() - 1;

        while (left <= right) {

            int midIndex = (left + right) / 2;

            int midValue = nums[midIndex];

            if (midValue == target) {
                return midIndex;
            }

            if (midValue < target) {
                left = midIndex + 1; // go right
            } else if (midValue > target) {
                right = midIndex - 1;
            }
            
        }


        return -1;
    }
};

/*


[ 

target = 9 => page 90

left = mid + 1 = 8
right = 9

mid = (8 + 9) / 2 = 8

0   1   2   3   4   5   6   7   8   9
10, 20, 30, 40, 50, 60, 70, 80, 90, 100


-----------------
target = 17

left = 6
right = 6

mid = (left + right) / 2
    = (0 + 9) / 2 = 4
    = (5 + 9) / 2 = 7
    = (5 + 6) / 2 = 5
    = (6 + 6) / 2 = 6

0  1  2  3  4   5   6   7   8   9     
-1 0  5  6  9  10  14  18  19  20

        while (left <= right) {

        if (arr[mid] < target) {
            //remove left part
            left = mid + 1;
        } else if (arr[mid] > target) {
            right = mid - 1
        } else {
            return mid
        }

    }

    return -1;


*/