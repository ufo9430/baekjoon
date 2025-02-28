import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int N;

    public static int[] board;

    public static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N];

        nqueen(0);
        System.out.println(count);
    }

    public static void nqueen(int index){
        if(index == N){
            count++;
            return;
        }
        for (int i = 0; i < N; i++) {
            board[index] = i;
            if(calculate(index)){
                nqueen(index+1);
            }
        }
    }

    public static boolean calculate(int index){
        for (int i = 0; i < index; i++) {
            if(board[index] == board[i]
                    || Math.abs(index - i) == Math.abs(board[index] - board[i])){
                return false;
            }
        }
        return true;
    }
}