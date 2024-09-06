import copy

ans = None
stop_recursion = False

class Solution:

    def solveSudoku(self, board) -> None:
        global ans, stop_recursion
        ans = None
        stop_recursion = False

        zeros = zero_counter(board)
        recurse(0, 0, zeros, board)

        for y in range(9):
            for x in range(9):
                board[y][x] = ans[y][x]

def recurse(y, x, zeros, board):
    global stop_recursion, ans
    if stop_recursion:
        return

    if zeros == 0:
        ans = copy.deepcopy(board)
        stop_recursion = True
        return

    if x == 9:
        recurse(y + 1, 0, zeros, board)
        return

    if board[y][x] != ".":
        recurse(y, x + 1, zeros, board)
        return

    for n in ("1", "2", "3", "4", "5", "6", "7", "8", "9"):
        if can_put(n, y, x, board):
            board[y][x] = n
            recurse(y, x + 1, zeros - 1, board)
            board[y][x] = "."


def zero_counter(board) -> int:
    ans = 0
    for y in range(9):
        for x in range(9):
            if board[y][x] == ".":
                ans += 1
    return ans


def can_put(n, y, x, board) -> bool:
    for i in range(9):
        if board[y][i] == n:
            return False

    for j in range(9):
        if board[j][x] == n:
            return False

    y0 = (y // 3) * 3
    x0 = (x // 3) * 3

    for addY in range(0, 3):
        for addX in range(0, 3):
            if board[y0 + addY][x0 + addX] == n:
                return False

    return True


sdk = [["5", "3", ".", ".", "7", ".", ".", ".", "."], ["6", ".", ".", "1", "9", "5", ".", ".", "."],
       [".", "9", "8", ".", ".", ".", ".", "6", "."], ["8", ".", ".", ".", "6", ".", ".", ".", "3"],
       ["4", ".", ".", "8", ".", "3", ".", ".", "1"], ["7", ".", ".", ".", "2", ".", ".", ".", "6"],
       [".", "6", ".", ".", ".", ".", "2", "8", "."], [".", ".", ".", "4", "1", "9", ".", ".", "5"],
       [".", ".", ".", ".", "8", ".", ".", "7", "9"]]
ins = Solution()
ins.solveSudoku(sdk)
print(sdk)
