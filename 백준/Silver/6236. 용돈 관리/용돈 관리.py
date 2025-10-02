import sys

N, M = map(int, sys.stdin.readline().split())
pays = []
for _ in range(N):
    pays.append(int(sys.stdin.readline()))

min = 1
max = sum(pays)
result = 0

while max >= min:
    mid = (min + max) // 2
    count = 1
    wallet = mid
    up = False
    for pay in pays:
        if pay > mid:
            up = True
            break
        if wallet - pay < 0:
            count += 1
            wallet = mid
        wallet -= pay
    
    if count > M or up:
        min = mid + 1
    else:
        result = mid
        max = mid - 1

print(result)