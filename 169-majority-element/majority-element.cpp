class Solution {
public:
    int majorityElement(vector<int>& nums) {
       int i = 0;
       int max = nums[i]; //6
       int cnt = 0;
       while(i< nums.size()){
        if(nums[i] == max){
            cnt++; //1
        }
        else{
            cnt--;
        }
        i++; //5
         if(cnt == 0){
            max = nums[i];
        }
       }
      

        return max;
    }
};