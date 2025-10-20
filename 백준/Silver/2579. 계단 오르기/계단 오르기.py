import sys
N = int(sys.stdin.readline())
stairs = []
dp = []
for _ in range(N):
    stairs.append(int(sys.stdin.readline()))

dp.append(stairs[0])
if N >= 2:
    dp.append(stairs[0] + stairs[1])
if N >= 3:
    dp.append(max(stairs[1]+stairs[2],stairs[0]+stairs[2]))

for i in range(3, N):
    dp.append(max(dp[i-3] + stairs[i-1] + stairs[i],
                  dp[i-2] + stairs[i]))

print(dp[-1])