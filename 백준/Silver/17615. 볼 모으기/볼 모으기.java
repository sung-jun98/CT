
import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static char[] input;
	static boolean flag;
	static int cntR, cntB;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		input = new char[N];
		input = br.readLine().toCharArray();
		flag = false;
		cntR = 0;
		cntB = 0;

		// R부터 시작
		for (int i = N - 1; i >= 0; i--) {
			if (input[i] == 'B') {
				cntB += 1;
			}
		}

		for (int i = N - 1; i >= 0; i--) {
			if (input[i] == 'R') {
				break;
			} else {
				cntB -= 1;
			}
		}

		// B부터 시작
		for (int i = N - 1; i >= 0; i--) {
			if (input[i] == 'R') {
				cntR += 1;
			}
		}

		for (int i = N - 1; i >= 0; i--) {
			if (input[i] == 'B') {
				break;
			} else  {
				cntR -= 1;
			}
		}

		System.out.println(Math.min(cntR, cntB));

	}

}
