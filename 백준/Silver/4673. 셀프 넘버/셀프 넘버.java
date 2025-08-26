import java.util.*;
import java.io.*;

public class Main {
    static boolean[] arr;
    
    public static void main(String[] args) throws Exception {
        arr = new boolean[10_001];
        for(int i = 1; i < 10_001; i++){
            if(!arr[i]){
                sum(i);
            }
        }
        
        for(int i = 1; i < 10_001; i++){
            if(!arr[i]){
                // if(i < 64 || i >= 9903){
                    // System.out.println(i);
                // }
                
                // if(i == 64){
                    // System.out.println(" | "+ '\n' + 
                    // "|       <-- a lot more numbers" + '\n' + 
                    // "|");
                // }
                System.out.println(i);
            } 
            
        }
    }
    
    private static void sum(int n){
        String input = String.valueOf(n);
        
        int numSum = n;
        for(int i = 0; i < input.length(); i++){
            numSum += input.charAt(i) - '0';
        }
        
        if(numSum < 10_001 && !arr[numSum]){
            arr[numSum] = true;
            sum(numSum);    
        }
        
        
    }
}
