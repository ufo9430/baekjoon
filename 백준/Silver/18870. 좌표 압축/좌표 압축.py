import sys
N = int(sys.stdin.readline())
X = list(map(int, sys.stdin.readline().split()))

sortedX = list(set(X))
sortedX.sort()
pairX = {}
for i in range(len(sortedX)):
    pairX[sortedX[i]] = i

for i in X:
    print(pairX[i], end= ' ')