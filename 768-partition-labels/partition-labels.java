class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] lastOccurance = new int[128];
        int len = s.length();

        for (int idx = 0; idx < len; ++idx) {
            lastOccurance[s.charAt(idx)] = idx;
        }

        List<Integer> list = new ArrayList<>();
        int st = 0, en = 0;

        for (int idx = 0; idx < len; ++idx) {
            en = Math.max(en, lastOccurance[s.charAt(idx)]);
            if (idx == en) {
                list.add(en - st + 1);
                st = idx + 1;
            }
        }

        return list;
    }
}