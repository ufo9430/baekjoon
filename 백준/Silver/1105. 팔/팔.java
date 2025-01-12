import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

         String L,R;
         int count = 0;

        String[] split = br.readLine().split(" ");

        L = split[0];
        R = split[1];

        int len = L.length();

        for (int i = 0; i < len; i++) {
            if(L.charAt(0) != R.charAt(0)){
                break;
            }
            if(L.charAt(0) == '8'){
                count ++;
            }
            L = L.substring(1);
            R = R.substring(1);
        }
        if(L.length() != R.length()){
            System.out.println(0);
        }else{
            System.out.println(count);
        }
    }
    private static int getGapLog(int gap) {
        if(gap > 0){
            return (int) Math.log10(Math.abs(gap));
        }else{
            return 0;
        }
    }
}
