class Solution {
    public boolean containsDuplicate(int[] nums) {
        var seen = new HashSet<Integer>();

        for (int num : nums)
            if (!seen.add(num)) return true;
        
    return false;
    }
}