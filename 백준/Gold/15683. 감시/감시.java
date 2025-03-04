import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    static int N, M;
    static int[][] board;
    static List<int[]> cctvs = new ArrayList<>();
    static int[] dx = {-1, 1, 0, 0}; // 상, 하, 좌, 우
    static int[] dy = {0, 0, -1, 1}; 

    static int result = Integer.MAX_VALUE;

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
                if (board[i][j] >= 1 && board[i][j] <= 5) {
                    cctvs.add(new int[]{i, j, board[i][j]});
                }
            }
        }

        process(0, board);

        System.out.println(result);
    }

    public static void process(int index, int[][] prevBoard) {
        if (index == cctvs.size()) {
            int count = countBlindSpots(prevBoard);
            result = Math.min(result, count);
            return;
        }

        int[][] copyBoard = copyBoard(prevBoard);
        int[] cctv = cctvs.get(index);
        int x = cctv[0], y = cctv[1], type = cctv[2];

        for (List<Integer> directions : getCCTVDirections(type)) {
            applySurveillance(copyBoard, x, y, directions);
            process(index + 1, copyBoard);
            copyBoard = copyBoard(prevBoard); // 백트래킹 (원상 복구)
        }
    }

    public static int[][] copyBoard(int[][] original) {
        int[][] copy = new int[N][M];
        for (int i = 0; i < N; i++) {
            copy[i] = Arrays.copyOf(original[i], M);
        }
        return copy;
    }

    public static void applySurveillance(int[][] board, int x, int y, List<Integer> directions) {
        for (int dir : directions) {
            int nx = x, ny = y;
            while (true) {
                nx += dx[dir];
                ny += dy[dir];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M || board[nx][ny] == 6) break;
                if (board[nx][ny] == 0) board[nx][ny] = -1; // 감시 구역 표시
            }
        }
    }

    public static int countBlindSpots(int[][] board) {
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == 0) count++;
            }
        }
        return count;
    }

    public static List<List<Integer>> getCCTVDirections(int type) {
        switch (type) {
            case 1: return List.of(List.of(0), List.of(1), List.of(2), List.of(3)); 
            case 2: return List.of(List.of(0, 1), List.of(2, 3));
            case 3: return List.of(List.of(0, 3), List.of(3, 1), List.of(1, 2), List.of(2, 0));
            case 4: return List.of(List.of(0, 2, 3), List.of(0, 1, 3), List.of(1, 2, 3), List.of(0, 1, 2));
            case 5: return List.of(List.of(0, 1, 2, 3));
        }
        return new ArrayList<>();
    }
}
