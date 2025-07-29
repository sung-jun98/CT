import java.util.*;
import java.io.*;

public class Main {
    static int M;
    static Set<Integer> set;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        M = Integer.parseInt(br.readLine());
        set = new HashSet<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            String[] inputs = br.readLine().split(" ");

            String result = calc(inputs);


            if(result != null){
                sb.append(result).append('\n');
            }
        }

        System.out.println(sb.toString());
    }

    private static String calc(String[] inputs) {
        int num = 0;

        if (inputs.length == 2) {
            num = Integer.parseInt(inputs[1]);
        }

        switch (inputs[0]) {
            case "add":
                set.add(num);

                break;

            case "remove":
                set.remove(num);

                break;

            case "check":
                if (set.contains(num)) {
                    return "1";
                } else {
                    return "0";
                }

            case "toggle":
                if (set.contains(num)) {
                    set.remove(num);
                } else {
                    set.add(num);
                }

                break;

            case "all":
                for (int i = 1; i <= 20; i++) {
                    set.add(i);
                }

                break;

            case "empty":
                set.clear();

                break;

        }

        return null;
    }
}
