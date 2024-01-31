class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        n = len(temperatures)
        stack = [0]*n
        res = [0]*n
        
        i = 0
        while (i < n):
            currTemp = temperatures[i]
            while(stack and temperatures[stack[-1]] < currTemp):
                tmp = stack.pop()
                res[tmp] = i-tmp
                
            stack.append(i)
            i=i+1
        return res
                
            