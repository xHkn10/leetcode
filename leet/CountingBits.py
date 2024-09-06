from typing import List


class Solution:
    base = list()
    calced = False

    @staticmethod
    def calc():
        for i in range(2 ** 16, 10 ** 5 + 1):
            Solution.base.append(i.bit_count())

    def countBits(self, n: int) -> List[int]:
        if not Solution.calced:
            Solution.calc()
            Solution.calced = True

        if n == 0:
            return [0]

        subtract = 1
        count = 0
        while subtract <= n:
            n -= subtract
            subtract *= 2
            count += 1

        ans = [0]
        for i in range(count):
            ans += Solution.base[:2 ** i]
        ans += Solution.base[:n]
        return ans


print(Solution().countBits(1))
