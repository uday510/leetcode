class Solution:
    def isNStraightHand(self, hand: List[int], groupSize: int) -> bool:
        freq = Counter(hand)
        
        for val in sorted(hand):
            if freq[val] == 0:
                continue
                
            for nei in range(val, val+groupSize):
                if freq[nei] == 0:
                    return False
                freq[nei] -= 1
        
        return sum(freq.values()) == 0