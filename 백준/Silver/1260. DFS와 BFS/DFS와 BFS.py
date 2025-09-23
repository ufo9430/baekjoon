from collections import deque
N, M, V = map(int, input().split())
queue = []
visited1 = [False]*(N+1)
visited2 = [False]*(N+1)
arr = [[0 for j in range(N+1)] for i in range(N+1)]
df = []
for i in range(M):
    x, y = map(int, input().split())
    arr[x][y] = arr[y][x] = 1
def DFS(x):
    visited1[x]=1
    print(str(x), end = " ")
    for i in range(N+1):
        if visited1[i] == 0 and arr[x][i] == 1:
            DFS(i)
DFS(V)
print()
def BFS(x):
    queue = deque([x])
    visited2[x] = 1
    while queue:
        q = queue.popleft()
        print(str(q), end = " ")
        for i in range(N+1):
            if visited2[i]==0 and arr[q][i] == 1:
                queue.append(i)
                visited2[i] = 1
BFS(V)