from collections import deque
N = int(input())
dx = [-1,0,1,0]
dy = [0,1,0,-1]
board = [] * N
apt = []
visited = [[False] * (N) for _ in range(N)]
for _ in range(N):
    board.append(input())

def check(x,y):
    return 0<=x<N and 0<=y<N

def bfs(x,y,visited):
    q = deque([(x,y)])
    result = 1
    visited[x][y] = True
    while q:
        curr_x,curr_y = q.popleft()
        for i in range(4):
            nx = curr_x + dx[i]
            ny = curr_y + dy[i]
            if check(nx,ny):
                if board[nx][ny] == '1' and not visited[nx][ny]:
                    visited[nx][ny] = True
                    q.append((nx,ny))
                    result += 1
    return result

for i in range(N):
    for j in range(len(board[i])):
        if board[i][j] == '1' and not visited[i][j]:
            apt.append(bfs(i,j,visited))

print(len(apt))
apt.sort()
for i in apt:
    print(i)