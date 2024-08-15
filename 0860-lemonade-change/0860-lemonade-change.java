class Solution {
    public boolean lemonadeChange(int[] bills) {
        int[] cnt = new int[21]; // Array to hold the count of 5, 10, and 20 dollar bills

        for (int bill : bills) {
            cnt[bill]++; // Increment the count of the current bill
            int needed = bill - 5; // Calculate the change needed

            for (int denom : new int[]{20, 10, 5}) {
                int countToUse = Math.min(needed / denom, cnt[denom]);
                needed -= countToUse * denom; // Reduce the needed change
                cnt[denom] -= countToUse; // Reduce the count of used bills
            }

            if (needed > 0) {
                return false;
            }
        }
        return true;
    }
}
