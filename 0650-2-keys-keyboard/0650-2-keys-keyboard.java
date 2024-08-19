class Solution {
    public int minSteps(int n) {
        return dfs(1, 0, n, 0);
    }
    
    private int dfs(int curr, int clipboard, int target, int steps) {
        // If the current number of 'A's equals the target, return the number of steps
        if (curr == target) {
            return steps;
        }
        
        // If the current number of 'A's exceeds the target, return a large number (invalid path)
        if (curr > target) {
            return Integer.MAX_VALUE;
        }
        
        // Option 1: Copy All and Paste
        int copyPaste = Integer.MAX_VALUE;
        if (clipboard != curr) { // Avoid redundant operations
            copyPaste = dfs(curr + curr, curr, target, steps + 2); // 2 steps: Copy and Paste
        }
        
        // Option 2: Paste Only
        int pasteOnly = Integer.MAX_VALUE;
        if (clipboard > 0) {
            pasteOnly = dfs(curr + clipboard, clipboard, target, steps + 1); // 1 step: Paste
        }
        
        // Return the minimum steps required
        return Math.min(copyPaste, pasteOnly);
    }
}
