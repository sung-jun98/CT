import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;

        while ((input = br.readLine()) != null) {
            N = Integer.parseInt(input);

            sb = new StringBuilder();
            for (int i = 0; i < Math.pow(3, N); i++) {
                sb.append("-");
            }

            if (N != 0) {
                function(0, (int) Math.pow(3, N) - 1);
            }

            System.out.println(sb.toString());
        }
    }

    private static void function(int start, int end) {
        int length = end - start + 1;

        if(length == 1){
            return ;
        }

        int segmentSize = length / 3;
        int midStart = start + segmentSize;
        int midEnd = midStart + segmentSize - 1;

        for(int i = midStart; i <= midEnd; i++){
            sb.setCharAt(i, ' ');
        }

        function(start, midStart - 1);
        function(midEnd + 1, end);
    }
}
