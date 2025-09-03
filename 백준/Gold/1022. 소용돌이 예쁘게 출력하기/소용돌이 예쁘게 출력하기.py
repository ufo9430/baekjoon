r1, c1, r2, c2 = map(int, input().split())
def findSpot(r,c):
    depth = abs(r) if abs(r) > abs(c) else abs(c)
    initialValueInDepth = (2 * depth + 1) ** 2
    startr, startc = depth, depth
    if(r == 0 and c == 0):
        return 1
    for _ in range(2 * depth):
        if(startr == r and startc == c):
            return initialValueInDepth
        startc -= 1
        initialValueInDepth -= 1
    for _ in range(2 * depth):
        if(startr == r and startc == c):
            return initialValueInDepth
        startr -= 1
        initialValueInDepth -= 1
    for _ in range(2 * depth):
        if(startr == r and startc == c):
            return initialValueInDepth
        startc += 1
        initialValueInDepth -= 1
    for _ in range(2 * depth):
        if(startr == r and startc == c):
            return initialValueInDepth
        startr += 1
        initialValueInDepth -= 1
matrix = []
for i in range(r1, r2+1):
    row = []
    for j in range(c1, c2+1):
        row.append(findSpot(i, j))
    matrix.append(row)

max_width = len(str(max(map(max, matrix))))

for row in matrix:
    print(" ".join(str(x).rjust(max_width) for x in row))