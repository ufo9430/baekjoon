import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int[] midget = new int[9];
    static boolean[] visited = new boolean[9];
    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 9; i++) {
            midget[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(midget);

        dfs(0,0);
    }

    public static void dfs(int start, int depth){
        if(depth == 7){
            int sum = 0;
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < 9; i++) {
                if(visited[i]){
                    sb.append(midget[i]).append("\n");
                    sum += midget[i];
                }
            }
            if (sum == 100) {
                System.out.println(sb);
                System.exit(0);
            }
        }

        for (int i = start; i < 9; i++) {
            visited[i] = true;
            dfs(i+1, depth + 1);
            visited[i] = false;
        }
    }
}