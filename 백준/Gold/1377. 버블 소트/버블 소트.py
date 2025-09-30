import sys
N = int(sys.stdin.readline().strip())
arr = []
for i in range(N):
    arr.append((int(sys.stdin.readline()), i))
result = 0
sorted_arr = sorted(arr, key= lambda x : x[0])

for i in range(N):
    diff = sorted_arr[i][1] - arr[i][1]
    result = max(result, diff)

print(result + 1)