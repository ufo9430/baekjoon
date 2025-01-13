import java.awt.image.ImageProducer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    static int N;

    static int[][] board = new int[25][25];

    static boolean[][] visited = new boolean[25][25];

    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    static List<Integer> houseCounts = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < 25; i++) {
            for (int j = 0; j < 25; j++) {
                board[i][j] = -1;
                visited[i][j] = false;
            }
        }

        for (int i = 0; i < N; i++) {
            char[] line = br.readLine().toCharArray();
            int j = 0;
            for (char c : line) {
                board[i][j++] = c - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(board[i][j] == 1 && !visited[i][j]){
                    houseCounts.add(dfs(i,j));
                }
            }
        }

        Collections.sort(houseCounts);
        System.out.println(houseCounts.size());
        for (Integer houseCount : houseCounts) {
            System.out.println(houseCount);
        }
    }

    public static boolean isOutOfRange(int x, int y) {
        return x < 0 || x >= N || y < 0 || y >= N;
    }

    public static int dfs(int x, int y) {
        visited[x][y] = true;
        int count = 1;
        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if (!isOutOfRange(nextX,nextY)){
                if(board[nextX][nextY] == 1 && !visited[nextX][nextY]){
                    count += dfs(nextX,nextY);
                }
            }
        }
        return count;
    }

}
