import sys

N, K = map(int, sys.stdin.readline().split())
lines = []
for _ in range(N):
    lines.append(int(sys.stdin.readline()))

minline = 1
maxline = max(lines)

result = 0

while maxline >= minline:
    midline = (minline + maxline) // 2
    count = 0
    for line in lines:
        count += line // midline
    if count >= K:
        result = midline
        minline = midline + 1
    else:
        maxline = midline - 1
    

print(result)