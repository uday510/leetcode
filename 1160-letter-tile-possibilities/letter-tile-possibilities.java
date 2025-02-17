class Solution {
    Set<String> res;
    
    public int numTilePossibilities(String tiles) {
        res = new HashSet<>();
        char[] arr = tiles.toCharArray();
        boolean[] visited = new boolean[arr.length];
        
        Arrays.sort(arr); 
        dfs(arr, new StringBuilder(), visited);
        
        return res.size();
    }

    private void dfs(char[] arr, StringBuilder sb, boolean[] visited) {
        if (sb.length() > 0) {
            res.add(sb.toString());
        }

        for (int i = 0; i < arr.length; i++) {
            if (visited[i] || (i > 0 && arr[i] == arr[i - 1] && !visited[i - 1])) {
                continue; 
            }

            sb.append(arr[i]);
            visited[i] = true;
            dfs(arr, sb, visited);
            visited[i] = false;
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}