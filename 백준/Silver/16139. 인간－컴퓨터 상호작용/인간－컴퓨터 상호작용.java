import java.util.*;
import java.io.*;

public class Main {
    static String S;
    static int q;
    static char alpha;
    static int l, r;

    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = br.readLine();
        q = Integer.parseInt(br.readLine());


        for (int t = 1; t <= q; t++) {
            String[] input = br.readLine().split(" ");

            alpha = input[0].charAt(0);
            l = Integer.parseInt(input[1]);
            r = Integer.parseInt(input[2]);

            arr = new int[S.length()];

            if (S.charAt(0) == alpha) {
                arr[0] = 1;
            } else {
                arr[0] = 0;
            }

            for (int i = 1; i < S.length(); i++) {
                if (S.charAt(i) == alpha) {
                    arr[i] = arr[i - 1] + 1;
                } else {
                    arr[i] = arr[i - 1];
                }
            }

            if (l == 0) {
                System.out.println(arr[r]);
            } else {
                System.out.println(arr[r] - arr[l - 1]);
            }
        }
    }
}
