import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N;
    static int[][] table;

    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        table = new int[2][N];

        for (int i = 0; i < N; i++) {
            String[] split = br.readLine().split(" ");
            table[0][i] = Integer.parseInt(split[0]);
            table[1][i] = Integer.parseInt(split[1]);
        }

        for (int i = 0; i < N; i++) {
            dfs(i, 0);
        }

        System.out.println(max);
    }

    public static void dfs(int index, int count){
        if(index >= N){
            max = Math.max(max, count);
            return;
        }
        int nextIndex = index + table[0][index];
        if(nextIndex <= N){
            dfs(nextIndex, count + table[1][index]);
        }
        
        dfs(index + 1, count);
    }
}