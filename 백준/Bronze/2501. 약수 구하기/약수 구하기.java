import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        K = Integer.parseInt(split[1]);
        int count = 0;
        for (int i = 1; i <= N; i++) {
            if(N % i == 0){
                if (++count == K){
                    System.out.println(i);
                    return;
                }
            }
        }
        System.out.println(0);
    }
}