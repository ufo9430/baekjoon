R, C = map(int ,input().split())
board = []
dx = (-1,0,1,0)
dy = (0,1,0,-1)
for _ in range(R):
    board.append(input())
alphabet = [False] * 26
totalDepth = 1
def check(x,y):
    return x < 0 or x >= R or y < 0 or y >= C
def dfs(x, y, depth):
    global totalDepth
    totalDepth = max(totalDepth, depth)
    for i in range(4):
        nx = x+dx[i]
        ny = y+dy[i]
        if not check(nx,ny):
            index = ord(board[nx][ny]) - 65
            if alphabet[index] == False:
                alphabet[index] = True
                dfs(nx,ny,depth + 1)
                alphabet[index] = False
alphabet[ord(board[0][0]) - 65] = True
dfs(0,0,1)
print(totalDepth)