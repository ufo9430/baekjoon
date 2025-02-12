import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int M;
    static int[][] board;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);
        int count = 0;

        board = new int[N+1][N+1];
        visited = new boolean[N+1];

        for (int i = 0; i < M; i++) {
            String[] split1 = br.readLine().split(" ");
            int x = Integer.parseInt(split1[0]);
            int y = Integer.parseInt(split1[1]);
            board[x][y] = board[y][x] = 1;
        }
        for (int i = 1; i <= N; i++) {
            if(!visited[i]){
                count++;
                dfs(i);
            }
        }

        System.out.println(count);
    }

    public static void dfs(int x){
        visited[x] = true;
        for (int i = 1; i <= N; i++) {
            if(board[x][i] == 1 && !visited[i]){
                dfs(i);
            }
        }
    }
}