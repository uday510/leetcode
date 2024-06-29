from typing import List
import collections

class Solution:
    def getAncestors(self, n: int, edges: List[List[int]]) -> List[List[int]]:
        rgraph = collections.defaultdict(set)
        
        for u, v in edges:
            rgraph[v].add(u)
        
        def dfs(node, seen):
            for nei in rgraph[node]:
                if nei not in seen:
                    seen.add(nei)
                    dfs(nei, seen)
        
        def get_ancestors_for_node(node):
            seen = set()
            dfs(node, seen)
            return sorted(seen)
        
        return list(map(get_ancestors_for_node, range(n)))

