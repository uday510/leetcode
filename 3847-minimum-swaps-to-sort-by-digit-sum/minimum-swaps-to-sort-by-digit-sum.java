class Solution {
    
    public int minSwaps(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        
        for (int i = 0; i < n; ++i) {
            list.add(nums[i]);
            map.put(nums[i], i);
        }

        list.sort((a, b) -> {
            int sumA = digitSum(a);
            int sumB = digitSum(b);
            if (sumA != sumB) {
                return sumA - sumB;
            }
            return a - b;
        });

        int numSwaps = 0;
        for (int i = 0; i < n; ++i) {
            int correctValue = list.get(i);

            if (nums[i] != list.get(i)) {
                int idxToSwap = map.get(correctValue);
                
                map.put(nums[i], idxToSwap);
                map.put(correctValue, i);

                swap(i, idxToSwap, nums);

                numSwaps++;
            }
        }

        return numSwaps;
    }

    private void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private int digitSum(int digit) {
        int sum = 0;
        while (digit > 0) {
            sum += digit % 10;
            digit /= 10;
        }
        return sum;
    }
}