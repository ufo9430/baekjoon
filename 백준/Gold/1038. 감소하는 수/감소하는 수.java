import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class Main {
    static int N;
    static List<Long> decreasingNum = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        generate();
        if(N >= decreasingNum.size()){
            System.out.println(-1);
        }else{
            System.out.println(decreasingNum.get(N));
        }
    }

    static void generate(){
        Queue<Long> queue = new LinkedList<>();

        for (int i = 0; i < 10; i++) {
            queue.add((long) i);
            decreasingNum.add((long) i);
        }
        while(!queue.isEmpty()){
            long num = queue.poll();
            long lastDigit = num % 10;
            for (int i = 0; i < lastDigit; i++) {
                long newNum = num*10 + i;
                queue.add(newNum);
                decreasingNum.add(newNum);
            }
        }
    }
}