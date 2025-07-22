import java.util.*;
import java.io.*;


public class Main {
    static String input;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input = br.readLine();
        StringBuilder sb = new StringBuilder();
        int point = 0;

        while (point < input.length()) {

            if (input.charAt(point) == '.') {
                point += 1;
                sb.append(".");
                continue;
            }

            int xCnt = 0;
            for (int i = point; i < input.length() && input.charAt(i) == 'X'; i++) {
                xCnt += 1;
            }

            if(xCnt >= 4){
                point += 4;
                sb.append("AAAA");

            } else if(xCnt >= 2){
                point += 2;
                sb.append("BB");

            } else{
                System.out.println(-1);
                return;
            }
        }

        System.out.println(sb.toString());
    }
}
