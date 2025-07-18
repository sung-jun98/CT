import java.util.*;
import java.io.*;

public class Main {
    static int[] S, E, Q;
    static Set<String> enteredMembers;
    static Set<String> exitedMembers;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String[] input1 = st.nextToken().split(":");
        String[] input2 = st.nextToken().split(":");
        String[] input3 = st.nextToken().split(":");

        S = new int[]{Integer.parseInt(input1[0]), Integer.parseInt(input1[1])};
        E = new int[]{Integer.parseInt(input2[0]), Integer.parseInt(input2[1])};
        Q = new int[]{Integer.parseInt(input3[0]), Integer.parseInt(input3[1])};

        enteredMembers = new HashSet<>();
        exitedMembers = new HashSet<>();

        String input;
        int answer = 0;

        while ((input = br.readLine()) != null) {
            String[] input4 = input.split(" ");
            int hour = Integer.parseInt(input4[0].split(":")[0]);
            int min = Integer.parseInt(input4[0].split(":")[1]);

            String name = input4[1];

            // 스트리밍 시간 이전
            if(hour < S[0] || (hour == S[0] && min <= S[1])){
                enteredMembers.add(name);
            }

            // 개강총회 끝난 이후 ~ 스트리밍 끝나기 전
            if(hour > E[0] || (hour == E[0] && min >= E[1])){
                if(hour < Q[0] || (hour == Q[0] && min <= Q[1])){
                    exitedMembers.add(name);
                }
            }
        }

        for(String name : enteredMembers){
            if(exitedMembers.contains(name)){
                answer += 1;
            }
        }

        System.out.println(answer);
    }
}
