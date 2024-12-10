class Solution {
    public int maximumLength(String s) {
         List<List<Integer>> list = new ArrayList<>();

        for (char c = 'a'; c <= 'z'; ++c) {
            list.add(new ArrayList<>());
        }

        int N = s.length();
        for (int i = 0; i < N;) {
            
            int j = i;
            while (j < N && s.charAt(i) == s.charAt(j)) {
                ++j;
            }
            
            int index = s.charAt(i) - 'a';
            list.get(index).add(j - i);
            
            i = j;
        }

        int res = -1;
        for (List<Integer> frequency : list) {
            int M = frequency.size();
            if (M == 0) continue;
            
            Collections.sort(frequency);
            
            res = Math.max(res, frequency.get(M - 1) - 2);
            
            if (M > 1) {
                res = Math.max(res, Math.min(frequency.get(M - 1) - 1, frequency.get(M - 2)));
            }
            
            if (M > 2) {
                res = Math.max(res, frequency.get(M - 3));
            }
            
        }
        
        return res == 0 ? -1 : res;
    }
}