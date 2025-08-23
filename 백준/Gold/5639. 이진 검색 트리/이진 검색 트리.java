import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int top = Integer.parseInt(br.readLine());
        Node root = new Node(top);
        
        while(true){
            String input = br.readLine();
            
            if(input == null){
                break;
                
            } else {
                int curr = Integer.parseInt(input);
                root.insert(curr);
            }
            
        }
        
        postOrder(root);
        
        
    }
    
    private static class Node {
        int head;
        Node left, right;
        
        Node(int head){
            this.head = head;
        }
        
        public void insert(int num){
            if(num < head){
                if(this.left == null){
                    this.left = new Node(num);
                } else{
                    this.left.insert(num);
                }
                
            } else {
                if(this.right == null){
                    this.right = new Node(num);
                } else{
                    this.right.insert(num);
                }
            }
        }
    }
    
    private static void postOrder(Node node){
        int head = node.head;
        Node left = node.left;
        Node right = node.right;
        
        if(left != null){
            postOrder(left);
        }
        
        if(right != null){
            postOrder(right);
        }
        
        System.out.println(head);
    }
}
