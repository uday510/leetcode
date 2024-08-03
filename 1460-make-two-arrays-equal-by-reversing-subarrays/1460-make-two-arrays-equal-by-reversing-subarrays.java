class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        int[] cnt = new int[1001];
        int n = target.length;
        int total = 0;

        for (int val : arr) {
            ++cnt[val];
            ++total;
        }

        for (int i = 0;  i < n && cnt[target[i]]-- > 0 && total-- > 0;  ++i);

        return total == 0;
    }
}