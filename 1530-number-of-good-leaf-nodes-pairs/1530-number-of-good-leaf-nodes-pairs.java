class Solution {
    List<List<TreeNode>> paths;
    int dist;
    public int countPairs(TreeNode root, int distance) {
        paths = new ArrayList<>();
        int pairs = 0;
        dist = distance;
        
        dfs(root, new ArrayList<>());
        
        // System.out.println(paths.size());
        
        for (int i = 0; i < paths.size(); ++i) {
            for (int j = i+1; j < paths.size(); ++j) {
                boolean isGood = checkGood(paths.get(i), paths.get(j));
                if (isGood) {
                    pairs++;
                }
            }
        }
        
        return pairs;
    }
    
public boolean checkGood(List<TreeNode> pair1, List<TreeNode> pair2) {
    int i = 0;
    int j = 0;
    int cnt = 0;
        
    while (i < pair1.size() && j < pair2.size() && pair1.get(i) == pair2.get(j)) {
        i++;
        j++;
    }
    
    return ((pair1.size() - i) + (pair2.size() - j) <= dist);
}



    public void dfs(TreeNode node, List<TreeNode> path) {
        if (node == null)
            return;
        
        path.add(node);
        if (node.left == null && node.right == null) {
            paths.add(new ArrayList<>(path));
            
        }
            
        
        dfs(node.left, path);
        dfs(node.right, path);
        
        path.remove(path.size() - 1);
    } 
}