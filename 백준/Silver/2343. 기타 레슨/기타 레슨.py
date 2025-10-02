import sys
N, M = map(int, sys.stdin.readline().split())
lecs = list(map(int, sys.stdin.readline().split()))
max = sum(lecs)
min = 1
result = 0

while max >= min:
    mid = (max + min) // 2
    count = 1
    lecsum = 0

    up = False
    for lec in lecs:
        if lec > mid:
            up = True
            break
        if lecsum + lec > mid:
            count += 1
            lecsum = lec
        else:
            lecsum += lec

    if count > M or up:
        min = mid + 1
    else:
        result = mid
        max = mid - 1

print(result)