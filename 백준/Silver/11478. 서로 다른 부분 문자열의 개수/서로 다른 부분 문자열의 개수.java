import java.util.*;
import java.io.*;

public class Main {
    static String input;
    static int left, right;
    static Set<String> set;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input = br.readLine();
        set = new HashSet<>();

        left = 0;
        right = input.length();

        for (int i = left; i < right; i++) {
            rotate(i);
        }

        System.out.println(set.size());
    }

    private static void rotate(int start){

        String curr = "";
        for (int i = start; i < right; i++) {
            curr += input.charAt(i);

            if(!set.contains(curr)){
               set.add(curr);
            }
        }
    }
}
