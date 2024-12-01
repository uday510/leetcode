class Solution {
    public boolean checkIfExist(int[] arr) {
        Set<Double> set = new HashSet<>();

        for (int num : arr) {
            double doubleNum = 2 * num;
            double halfNum = (double) num / 2;

            if (set.contains(doubleNum) || set.contains(halfNum)) {
                return true;
            }

            set.add((double) num);
        }

        return false;
    }
}