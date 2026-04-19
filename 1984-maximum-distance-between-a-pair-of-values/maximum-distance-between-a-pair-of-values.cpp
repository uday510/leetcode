class Solution {
public:
    int maxDistance(vector<int>& nums1, vector<int>& nums2) {
        int left = 0;
        int right = 0;
        int ans = 0;
        while(left<nums1.size() && right<nums2.size()){
            // if(left > right){
            //     right++;
            //     continue;

            // }
            if(nums1[left]<=nums2[right]){
                ans = max(ans,right-left);
                right++;

            }
            else{
                left++;
            }
        }
        return ans;
        
    }
};

/*
If nums1[i] <= nums2[j]:

This is a valid pair
Update answer with j - i
Move j forward to try for a larger distance...other wise its invalid pair */