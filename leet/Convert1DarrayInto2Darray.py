from typing import List


class Solution:
    def construct2DArray(self, original: List[int], m: int, n: int) -> List[List[int]]:
        if m * n != len(original):
            return list()

        ans = [[0 for _ in range(n)] for _ in range(m)]
        idx = 0
        for y in range(m):
            for x in range(n):
                ans[y][x] = original[idx]
                idx += 1
        return ans