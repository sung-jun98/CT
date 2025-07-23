import java.util.*;
import java.io.*;


public class Main {
    static String input;
    static String[] opt = {"000", "001", "010", "011", "100", "101", "110", "111"};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input = br.readLine();

        if (input.equals("0")) {
            System.out.println(0);
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            int curr = input.charAt(i) - '0';

            sb.append(opt[curr]);
        }


        while (sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }

        System.out.println(sb.toString());
    }
}
