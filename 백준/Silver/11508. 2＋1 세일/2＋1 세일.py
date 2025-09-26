N = int(input())
C = []
bag = []
result = 0
for _ in range(N):
    C.append(int(input()))
C.sort()
C.reverse()
for i in range(N):
    result += C[i]
    bag.append(C[i])
    if len(bag) == 3:
        result -= bag[2]
        bag = []
print(result)