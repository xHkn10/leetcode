class Solution:
    def reverseBits(self, n: int) -> int:
        ans = 0
        pos = 31
        while n != 0:
            bit = n % 2
            n >>= 1
            ans |= bit << pos
            pos -= 1
        return ans

print(Solution().reverseBits(0b000010100101000001111010011100))
