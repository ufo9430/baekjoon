import sys
N, M = map(int, sys.stdin.readline().split())
woods = list(map(int, sys.stdin.readline().split()))

minwood = 0
maxwood = max(woods)
result = 0

while maxwood >= minwood:
    cut = 0
    midwood = (minwood + maxwood) // 2
    for wood in woods:
        if wood > midwood:
            cut += wood - midwood
    if cut >= M:
        result = midwood
        minwood = midwood + 1
    else:
        maxwood = midwood - 1

print(result)