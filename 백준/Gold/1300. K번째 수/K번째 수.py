import sys
N = int(sys.stdin.readline())
K = int(sys.stdin.readline())

arr = []

left = 0 
right = K

result = 0

while right >= left:
    mid = (left + right) // 2
    count = 0
    for i in range(N):
        count += min(mid // (i+1), N)
    if count >= K:
        result = mid
        right = mid - 1
    else:
        left = mid + 1
print(result)