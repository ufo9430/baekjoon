import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static long A, B;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        A = Long.parseLong(split[0]);
        B = Long.parseLong(split[1]);
        int count = 1;
        while (B > A) {
            if (B % 10 == 1) {
                B = (B - 1) / 10;
            } else if (B % 2 == 0) {
                B /= 2;
            } else {
                break;
            }
            count++;
        }
        System.out.println(B == A ? count : -1);
    }
}