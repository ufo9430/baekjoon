import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int result = 0;

        int charge = 1000 - N;

        while(500 <= charge){
            charge -= 500;
            result++;
        }
        while(100 <= charge){
            charge -= 100;
            result++;
        }
        while(50 <= charge){
            charge -= 50;
            result++;
        }
        while(10 <= charge){
            charge -= 10;
            result++;
        }
        while(5 <= charge){
            charge -= 5;
            result++;
        }
        while(1 <= charge){
            charge -= 1;
            result++;
        }
        System.out.println(result);
    }
}