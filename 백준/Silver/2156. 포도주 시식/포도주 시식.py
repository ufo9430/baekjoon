import sys
N = int(sys.stdin.readline())
podo = []
dp = []
for _ in range(N):
    podo.append(int(sys.stdin.readline()))

dp.append(podo[0])
if N >= 2:
    dp.append(podo[0] + podo[1])
if N >= 3:
    dp.append(max(dp[1], podo[0] + podo[2], podo[1] + podo[2]))

for i in range(3, N):
    dp.append(max(
        dp[i-1],
        dp[i-3] + podo[i-1] + podo[i],
        dp[i-2] + podo[i]))

print(dp[N-1])