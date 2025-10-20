import sys

N = int(sys.stdin.readline())
board = []
for _ in range(N):
    board.append(list(map(int, sys.stdin.readline().split())))
dp = [board[0]]

for i in range(1, N):
    first = min(dp[i-1][1], dp[i-1][2]) + board[i][0]
    second = min(dp[i-1][0], dp[i-1][2]) + board[i][1]
    third = min(dp[i-1][0], dp[i-1][1]) + board[i][2]
    dp.append([first, second, third])

print(min(dp[N-1]))