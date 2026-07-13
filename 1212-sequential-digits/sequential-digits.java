class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> res = new ArrayList<>();

        for (int s : new Seq().seq) {
            if (s >= low && s <= high)
                res.add(s);
        }

        return res;
    }
}

class Seq {
    List<Integer> seq;
    
    Seq() {
        String s = "123456789";
        int n = 10;
        seq = new ArrayList<>();

        for (int len = 2; len < n; len++) {
            for (int i = 0; i + len <= n - 1; i++) {
                int cur = Integer.parseInt(s.substring(i, i + len));
                seq.add(cur);
            }
        }
    }
}