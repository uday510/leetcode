class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {

     int[] indegree = new int[n];

     for (List<Integer> e : edges)  {
        indegree[e.getLast()]++;
     }  

     List<Integer> res = new ArrayList<>();
     for (int idx = 0; idx < n; idx++) {
        if (indegree[idx] == 0)
            res.add(idx);
     }

     return res;
    }
}