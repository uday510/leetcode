class Solution:
    def maxScoreWords(self, words: List[str], letters: List[str], score: List[int]) -> int:
        
        counter = Counter(letters)
        seen = set(words)
        score = {chr(index+ord('a')) : val for index, val in enumerate(score)}
        
        wscore = collections.defaultdict()
        
        for word in words:
            s = 0
            for ch in word:
                s += score[ch]
                
            wscore[word] = s
            
        n = len(words)
                    
        
        def dfs(index, counter):
            if index >= n:
                return 0
            
            dont = dfs(index+1, counter)
            take = -inf
            word = words[index]
            if counter >= Counter(word):
                for ch in word:
                    counter[ch] -= 1
                take = wscore[word] + dfs(index+1, counter)
                for ch in word:
                    counter[ch] += 1
            
            return max(dont, take)
                
        return dfs(0, counter)