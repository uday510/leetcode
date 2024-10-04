class Solution {
    public long dividePlayers(int[] skill) {
        Arrays.sort(skill);
        int N = skill.length;
        long total = 0;

        int target = skill[0] + skill[N-1];

        int i = 0;
        int j = N - 1;
        while (i < j) {
            int curr = skill[i] + skill[j];

            if (curr != target) {
                return -1;
            }
            total += (long)skill[i++] * (long)skill[j--];
        }
        return total;
    }
}