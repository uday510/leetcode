class Solution {
    public List<List<Integer>> generate(int n) {
        List<List<Integer>> list = new ArrayList();
        list.add(new ArrayList<>(Arrays.asList(1)));

        for (int i = 1; i < n; i++) {

            List<Integer> cur = new ArrayList<>();

            cur.add(1);

            List<Integer> last = list.get(list.size() - 1);
            for (int j = 1; j < last.size(); j++) {
                cur.add(last.get(j) + last.get(j - 1));
            }

            cur.add(1);

            list.add(cur);
        }

        return list;
    }
}