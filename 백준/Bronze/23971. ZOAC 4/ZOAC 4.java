
import java.io.*;
import java.util.*;

public class Main{
	static int H, W, N, M;
    static int height, width;
    static int answer;
    
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int height =  H / (N + 1);
        int width = W / (M + 1);
        
        if(H % (N + 1) > 0) {
        	height += 1;
        }
        
        if(W % (M + 1) > 0) {
        	width += 1;
        }
        

        answer = height * width;

        System.out.println(answer);
	}
}
