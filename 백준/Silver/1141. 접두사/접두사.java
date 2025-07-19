import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static List<String> inputs;
    static int answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        inputs = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String line2 = br.readLine();
            inputs.add(line2);
        }

        if (N == 0) {
            System.out.println(answer);
            return;
        }

        Collections.sort(inputs, (a, b) -> Integer.compare(b.length(), a.length()));
        List<String> selected = new ArrayList<>();

        flag:
        for (String curr : inputs) {
            for (String exist : selected) {
                if (exist.indexOf(curr) == 0) {
                    continue flag;
                }
            }

            selected.add(curr);
        }

        System.out.println(selected.size());


    }
}
