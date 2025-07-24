import java.util.*;
import java.io.*;

public class Main {
    static int input;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        input = Integer.parseInt(br.readLine());

        if(input % 4 == 0){
            if((input % 100 != 0) || (input % 400 == 0)){
                System.out.println(1);
                return ;
            }
        }

        System.out.println(0);
    }
}
