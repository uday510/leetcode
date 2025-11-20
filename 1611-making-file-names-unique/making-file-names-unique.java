class Solution {
    public String[] getFolderNames(String[] names) {
        int n = names.length;
        String[] res = new String[n];
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String name = names[i];

            if (!map.containsKey(name)) {
                res[i] = name;
                map.put(name, 1);
                continue;
            }

            int k = map.get(name);
            String newName = name + "(" + k + ")";

            while (map.containsKey(newName)) {
                k++;
                newName = name + "(" + k + ")";
            }

            res[i] = newName;
            map.put(name, k);

            map.put(newName, 1);
        }

        return res;
    }
}