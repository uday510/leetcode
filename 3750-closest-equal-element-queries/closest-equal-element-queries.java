import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

    public List<Integer> solveQueries(int[] arr, int[] queries) {
        int n = arr.length;

        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++)
            map.computeIfAbsent(arr[i], _ -> new ArrayList<>()).add(i);


        List<Integer> res = new ArrayList<>();

        for (int q : queries) {
            int val = arr[q];
            var indices = map.get(val);
            int m = indices.size();

            if (indices.size() == 1) {
                res.add(-1);
                continue;
            }

            int pos = bs(indices, q);

            int prv = indices.get( (pos - 1 + m) % m);
            int nxt = indices.get( (pos + 1) % m);

            int d1 = Math.min(Math.abs(q - prv), n - Math.abs(q - prv));
            int d2 = Math.min(Math.abs(q - nxt), n - Math.abs(q - nxt));

            res.add(Math.min(d1, d2));
        }
        
        return res;
    }
    
    private int bs(List<Integer> list, int t) {
        int l = 0, r = list.size();
        
        while (l < r) {
            
            int m = l + (( r - l) >> 1);
            
            if (list.get(m) < t) l = m + 1;
            else r = m;
        }
        
        return l;
    }
}

/**
 
Input: arr = [1,3,1,4,1,3,2], queries = [0,3,5]

q = 0
indices = [0, 2, 4]
pos = 0
prv = 4
nxt = 2
d1 = min(abs(0 - 4), 7 - abs(0 - 4)) = 3
d2 = min(abs(0 - 2), 7 - abs(0 - 2)) = 2
mn = 2

 */