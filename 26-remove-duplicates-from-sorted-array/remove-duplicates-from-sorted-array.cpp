class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        
        int index = 0;
        int cnt = 0;
        int prev = nums[0];

        for (int i = 0; i < nums.size(); i++) {

            int cur = nums[i];

            if (prev == cur) cnt++;

            if (cnt == 1) {
                nums[index++] = cur;
            } else {
                cnt = 1;
            }

            prev = cur;
        }

        return index;
    }
};


/*

index = 0
cnt = 1
int prev = 0

[0,0,1,1,1,2,2,3,3,4]
    cur = nums[i]

    if (prev == cur) cnt++;

    if (cnt == 1) { 
        nums[index++] = cur;
    } else {
        cnt = 0
    }



**/