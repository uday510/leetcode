class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        if not digits: return []
        
        def dfs(index, res):
            if index >= N:
                ans.append("".join(res))
                return
            letters = pletters[str(digits[index])]
            for letter in letters:
                res.append(letter)
                dfs(index+1,res)
                res.pop()

        N = len(digits)
        ans = []
        pletters = {
            '2': 'abc',
            '3': 'def',
            '4': 'ghi',
            '5': 'jkl',
            '6': 'mno',
            '7': 'pqrs',
            '8': 'tuv',
            '9': 'wxyz',
        }

        dfs(0,[])
        return ans
        