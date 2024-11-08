class Solution {
    public String simplifyPath(String path) {
        var dirs = path.split("/");
        var stack = new Stack<String>();

        for (String dir : dirs) {
            handleDir(dir, stack);
        }

        return "/" + String.join("/", stack);
    }
    private void handleDir(String dir, Stack<String> stack) {
        if (dir.equals("..")) {
            if (!stack.isEmpty()) {
                stack.pop();
            }
        } else if (!dir.isEmpty() && !dir.equals(".")) {
            stack.push(dir);
        }
    }
}