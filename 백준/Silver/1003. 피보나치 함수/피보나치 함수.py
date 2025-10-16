import sys
zeros = [1, 0]
ones = [0, 1]
for i in range(2, 41):
    zeros.append(zeros[i-1] + zeros[i-2])
    ones.append(ones[i-1] + ones[i-2])

T = int(sys.stdin.readline())
for _ in range(T):
    N = int(sys.stdin.readline())
    print(zeros[N], ones[N])