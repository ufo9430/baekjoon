import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N, M;
    static int[] A;

    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);
        A = new int[N];
        line = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(line[i]);
        }

        for (int i = 0; i < N; i++) {
            int count = 0;
            for (int j = i; j < N; j++) {
                count += A[j];
                if(count == M){
                    result++;
                    break;
                }
            }
        }
        System.out.println(result);
    }

}