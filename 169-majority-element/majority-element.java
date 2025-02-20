class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxCount = 0;
        int maxKey = 0;

        for (int num : nums) {
           // put(key, value)
           int key = num;
           int value = map.getOrDefault(key, 0);
           map.put(key, value + 1);

           if (map.get(key) > maxCount) {
                maxKey = key;
                maxCount = map.get(key);
           }
        }

        return maxKey;
    }
}
