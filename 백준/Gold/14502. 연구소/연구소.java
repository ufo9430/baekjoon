import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int N, M;

    static int[][] board;

    static final int[] dx = new int[]{-1,0,1,0};
    static final int[] dy = new int[]{0,1,0,-1};

    static int result = 0;

    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);

        board = new int[N][M];

        for (int i = 0; i < N; i++) {
            line = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(line[j]);
                if (board[i][j] == 2) {
                    queue.add(new int[]{i, j});
                }
            }
        }

        process(0, deepCopyBoard(board));

        System.out.println(result);
    }

    public static void process(int index, int[][] currBoard) {
        if (index == 3) {
            result = Math.max(result, bfs(new LinkedList<>(queue), deepCopyBoard(currBoard)));
            return;
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (currBoard[i][j] == 0) {
                    currBoard[i][j] = 1;
                    process(index + 1, deepCopyBoard(currBoard));
                    currBoard[i][j] = 0;
                }
            }
        }
    }

    public static int bfs(Queue<int[]> viruses, int[][] currBoard) {

        while (!viruses.isEmpty()) {
            int[] poll = viruses.poll();
            for (int i = 0; i < 4; i++) {
                int nx = poll[0] + dx[i];
                int ny = poll[1] + dy[i];
                if(!check(nx,ny)){
                    if(currBoard[nx][ny] == 0){
                        currBoard[nx][ny] = 2;
                        viruses.add(new int[]{nx,ny});
                    }
                }
            }
        }

        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (currBoard[i][j] == 0) {
                    count++;
                }
            }
        }

        return count;
    }

    private static boolean check(int x, int y) {
        return x < 0 || x >= N || y < 0 || y >= M;
    }

    private static int[][] deepCopyBoard(int[][] original) {
        int[][] copy = new int[N][M];
        for (int i = 0; i < N; i++) {
            System.arraycopy(original[i], 0, copy[i], 0, M);
        }
        return copy;
    }
}