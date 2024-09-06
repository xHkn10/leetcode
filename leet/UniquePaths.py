import math


class Solution:
    def uniquePaths(self, m: int, n: int) -> int:

        if m <= n:
            return paths(m - 1, n - 1)
        return paths(n - 1, m - 1)


def paths(m, n) -> int:
    return fact(n, m + n) // fact(0, m)


def fact(start, end) -> int:
    if end == start:
        return 1
    ans = start + 1
    for i in range(start + 2, end + 1):
        ans *= i
    return ans


print(Solution().uniquePaths(3, 7))
print(Solution().uniquePaths(3, 2))
print(Solution().uniquePaths(1, 2))
print(Solution().uniquePaths(1, 10))
