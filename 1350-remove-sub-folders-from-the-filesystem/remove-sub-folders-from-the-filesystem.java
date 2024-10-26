class Solution {
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);

        var res = new ArrayList<String>();
        int len = folder.length;
        res.add(folder[0]);

        for (int idx = 1; idx < len; ++idx) {
            String lastFolder = res.getLast() + "/";
            String currFolder = folder[idx];

            if (!currFolder.startsWith(lastFolder)) {
                res.add(currFolder);
            }
        }
        return res;
    }
}