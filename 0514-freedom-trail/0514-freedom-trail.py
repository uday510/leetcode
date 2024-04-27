class Solution:
    def findRotateSteps(self, ring: str, key: str) -> int:
        MOD = n = len(ring)
        
        def neighbors(dial):
            for step in range(n):
                anti_clock = (dial - step) % MOD
                clock = (dial + step) % MOD
                for ndial in (anti_clock, clock):
                    yield step, ndial
        
        @cache
        def dfs(dial, index):
            if index >= len(key):
                return 0
            
            steps = inf
            
            for step, ndial in neighbors(dial):
                if ring[ndial] == key[index]:
                    steps = min(steps, step + dfs(ndial, index+1))
            
            return steps
        
        return len(key) + dfs(0, 0)