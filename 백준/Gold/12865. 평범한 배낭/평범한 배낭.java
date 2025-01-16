import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static int K;
    static int[] W = new int[101];
    static int[] V = new int[101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] first = br.readLine().split(" ");
        N = Integer.parseInt(first[0]);
        K = Integer.parseInt(first[1]);

        int[][] dp = new int[101][100001];

        for (int i = 1; i <= N; i++) {
            String[] line = br.readLine().split(" ");
            W[i] = Integer.parseInt(line[0]);
            V[i] = Integer.parseInt(line[1]);
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= K; j++) {
                if(j - W[i] >= 0){
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-W[i]] + V[i]);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        System.out.println(dp[N][K]);
    }
}
