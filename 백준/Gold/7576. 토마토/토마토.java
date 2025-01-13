import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int M, N;

    static int[][] board;
    static boolean[][] visited;

    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        M = Integer.parseInt(split[0]);
        N = Integer.parseInt(split[1]);
        board = new int[N][M];
        visited = new boolean[N][M];

        Queue<int[]> queue = new LinkedList<>();
        int result = 0;

        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(line[j]);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(board[i][j] == 1){
                    queue.add(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        while(!queue.isEmpty()){
            int[] poll = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = poll[0] + dx[i];
                int ny = poll[1] + dy[i];
                if(!isOutofRange(nx,ny) && !visited[nx][ny] && board[nx][ny] == 0){
                    queue.add(new int[]{nx,ny});
                    visited[nx][ny] = true;
                    board[nx][ny] = board[poll[0]][poll[1]] + 1;
                }
            }
        }

        Loop:
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(board[i][j] == 0){
                    System.out.println(-1);
                    return;
                }
                result = Math.max(result,board[i][j]);
            }
        }

        System.out.println(result-1);
    }

    public static boolean isOutofRange(int x, int y){
        return (x < 0 || x >= N || y < 0 || y >= M);
    }
}
