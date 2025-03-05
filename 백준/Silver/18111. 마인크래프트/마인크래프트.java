import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N, M, B;
    static int[][] board;

    static int resultTime = Integer.MAX_VALUE;

    static int resultHeight = 0;
    

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);
        B = Integer.parseInt(line[2]);

        board = new int[N][M];

        int minHeight = 256, maxHeight = 0;

        for (int i = 0; i < N; i++) {
            line = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(line[j]);
                minHeight = Math.min(minHeight, board[i][j]);
                maxHeight = Math.max(maxHeight, board[i][j]);
            }
        }

        for (int currentHeight = minHeight; currentHeight <= 256; currentHeight++) {
            int removedBlocks = 0, addedBlocks = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    int gap = board[i][j] - currentHeight;
                    if (gap > 0) {
                        removedBlocks += gap;
                    } else if (gap < 0) {
                        addedBlocks -= gap;
                    }
                }
            }

            if (B + removedBlocks < addedBlocks) {
                continue;
            }

            int time_count = (removedBlocks * 2) + addedBlocks;

            if (time_count < resultTime || (time_count == resultTime && currentHeight > resultHeight)) {
                resultTime = time_count;
                resultHeight = currentHeight;
            }
        }

        System.out.println(resultTime + " " + resultHeight);
    }
}