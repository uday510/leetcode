class Solution {
    public int minOperations(String[] logs) {
        int ops = 0;
        
        for (String log : logs) {
            if (log.equals("../")) {
                if (ops > 0) ops--;
            } else if (!log.equals("./")) {
                ops++;
            }
        }
        return ops;
    }
}