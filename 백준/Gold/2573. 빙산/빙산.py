from collections import deque

N, M = map(int, input().split())
arr = []
dx = [-1,0,1,0]
dy = [0,-1,0,1]
for _ in range(N):
    arr.append(list(map(int, input().split())))
def check(x,y):
    return not (x<0 or x>=N or y<0 or y>=M)
def bfs(x, y, visited):
    q = deque([(x, y)])
    visited[x][y] = True
    while q:
        cx, cy = q.popleft()
        for i in range(4):
            nx, ny = cx + dx[i], cy + dy[i]
            if check(nx, ny) and not visited[nx][ny] and arr[nx][ny] > 0:
                visited[nx][ny] = True
                q.append((nx, ny))
def solve() : 
    year = 0
    global arr
    while(True):
        iceberg_count = 0
        visited = [[False] * M for _ in range(N)]
        
        for i in range(N):
            for j in range(M):
                if arr[i][j] > 0 and not visited[i][j]:
                    bfs(i, j, visited)
                    iceberg_count += 1
        
        if iceberg_count >= 2:
            print(year)
            return
        
        if iceberg_count == 0:
            print(0)
            return
        
        temp_arr = [row[:] for row in arr]
        for i in range(N):
            for j in range(M):
                if arr[i][j] > 0:
                    sea_count = 0
                    for k in range(4):
                        ni, nj = i + dx[k], j + dy[k]
                        if check(ni, nj) and arr[ni][nj] == 0:
                            sea_count += 1
                    
                    temp_arr[i][j] = max(0, arr[i][j] - sea_count)
        
        
        arr = temp_arr
        year += 1   

solve()