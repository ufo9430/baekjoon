import sys
N, M = map(int, sys.stdin.readline().split())
board = []
dp = [[0 for _ in range(M)]] * N
for _ in range(N):
    board.append(list(map(int, sys.stdin.readline().split())))

def check(x,y):
    return 0<=x<N and 0<=y<M

for i in range(N):
    for j in range(M):
        left = 0
        up = 0
        if check(i-1,j):
            left = dp[i-1][j]
        if check(i,j-1):
            up = dp[i][j-1]
        dp[i][j] = max(left, up) + board[i][j]

print(dp[N-1][M-1])