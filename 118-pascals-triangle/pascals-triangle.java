class Solution {
    public List<List<Integer>> generate(int rows) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>(Arrays.asList(1)));

        if (rows == 1) return list;

        for (int i = 1; i < rows; i++) {

            var p = list.get(i - 1);
            list.add(new ArrayList<>());
            var c = list.getLast();

            c.add(1);

            for (int j = 0; j < p.size() - 1; j += 1) {
                c.add(p.get(j) + p.get(j + 1));
            }   

            c.add(1);
        }

        return list;
    }
}