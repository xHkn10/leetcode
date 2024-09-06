class Solution:
    def isPowerOfFour(self, n: int) -> bool:
        return n > 0 and bin(n).count("1") == 1 and len(bin(n)) % 2 == 1


print(Solution().isPowerOfFour(16))