class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        
        Arrays.sort(potions);
        
        int n = spells.length, m = potions.length;
        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            
            int spell = spells[i];
            int l = 0, r = m;


            while (l < r) {
                int mid = l + ( (r - l) >> 1);

                long cur = (long) spell * potions[mid];

                if (cur < success) l = mid + 1;
                else r = mid;
            }

            res[i] = m - l;
        }

        return res;
    }
}