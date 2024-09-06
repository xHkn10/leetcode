class Solution:
    def findComplement(self, num: int) -> int:
        ones = 1
        while ones <= num:
            ones <<= 1
        ones -= 1
        return num ^ ones


print(Solution().findComplement(5))
