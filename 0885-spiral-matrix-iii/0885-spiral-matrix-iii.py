class Solution:
    def spiralMatrixIII(self, rows: int, cols: int, rStart: int, cStart: int) -> List[List[int]]:
        directions = [(0, 1, 1), (1, 0, 0), (0, -1, 1), (-1, 0, 0)]
        y, x, s, d = rStart, cStart, 0, 0
        coords = [[y, x]]
        while len(coords) < rows * cols:
            s += directions[d][2]
            for _ in range(s):
                y, x = y + directions[d][0], x + directions[d][1]
                if 0 <= y < rows and 0 <= x < cols:
                    coords.append([y, x])
            d = (d + 1) % 4
        return coords