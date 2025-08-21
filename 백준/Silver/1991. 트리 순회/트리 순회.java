import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static Map<Character, Node> nodes;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        nodes = new HashMap<>();
        
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            char parent = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);
            
            Node node = new Node(parent, left, right);
            
            nodes.put(parent, node);
        }
        
        preOrder('A');
        System.out.println();
        inOrder('A');
        System.out.println();
        postOrder('A');
    }
    
    private static void preOrder(char input){
        Node node = nodes.get(input);
        char left = node.left;
        char right = node.right;
        
        System.out.print(input);
        
        if(left != '.'){
            preOrder(left);
        }
        
        if(right != '.'){
            preOrder(right);
        }
    }
    
    private static void inOrder(char input){
        Node node = nodes.get(input);
        char left = node.left;
        char right = node.right;
        
        
        if(left != '.'){
            inOrder(left);
        }
        
        System.out.print(input);
        
        if(right != '.'){
            inOrder(right);
        }
    }
    
    private static void postOrder(char input){
        Node node = nodes.get(input);
        char left = node.left;
        char right = node.right;
        
        
        if(left != '.'){
            postOrder(left);
        }
        
        if(right != '.'){
            postOrder(right);
        }
        
        System.out.print(input);
    }
    
    private static class Node {
        char parent;
        char left;
        char right;
        
        Node(char parent, char left, char right){
            this.parent = parent;
            this.left = left;
            this.right = right;
        }
    }
}
