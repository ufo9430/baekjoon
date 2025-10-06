import sys
N, C = map(int, sys.stdin.readline().split())
X = []
for _ in range(N):
    X.append(int(sys.stdin.readline()))

X.sort()
left = 1
right = max(X) - min(X)

result = 0

while right >= left:
    mid = (left + right) // 2
    latestDevice = X[0]
    count = 1
    for x in X[1:]:
        if x - latestDevice >= mid:
            count += 1
            latestDevice = x
    if count >= C:
        result = mid
        left = mid + 1
    else:
        right = mid - 1
    

print(result)