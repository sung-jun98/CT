import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        
        String output = input.replace("c=", "a").replace("c-", "a").replace("dz=", "a").replace("dz=", "a").replace("d-", "a").replace("lj", "a").replace("nj", "a").replace("s=", "a").replace("z=", "a");
        
        System.out.println(output.length());
    }
}
