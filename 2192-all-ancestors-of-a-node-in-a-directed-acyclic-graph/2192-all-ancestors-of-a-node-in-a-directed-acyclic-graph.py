from typing import List
import collections

class Solution:
    def getAncestors(self, n: int, edges: List[List[int]]) -> List[List[int]]:
        rgraph = collections.defaultdict(set)
        
        for u, v in edges:
            rgraph[v].add(u)
        
        memo = {}
        
        def dfs(node):
            if node in memo:
                return memo[node]
            
            ancestors = set()
            for nei in rgraph[node]:
                ancestors.add(nei)
                ancestors.update(dfs(nei))
            
            memo[node] = sorted(ancestors)
            return memo[node]
        
        return list(map(dfs, range(n)))
