class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        int[] cnt = new int[1001];
        int n = target.length;
        int total = 0;
        
        for (int val : arr) {
            ++cnt[val];
            ++total;
        }
        
        int i = 0;
        for (; i < n && cnt[target[i++]]-- > 0 && total-- > 0;);

        return total == 0;
    }
}