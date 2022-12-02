import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static class Node {
        Node left, right;
        int val;
        
        public Node(int val){
            this.val = val;
        }

        public void insertNode(int val){
            if(this.val < val){
                if(this.right == null) this.right = new Node(val);
                else this.right.insertNode(val);
            }
            else{
                if(this.left == null) this.left = new Node(val);
                else this.left.insertNode(val);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Node root = null;
        while(true){
            String input = br.readLine();
            if(input == null || input.equals("")) break;
            if(root == null) root = new Node(Integer.parseInt(input));
            else root.insertNode(Integer.parseInt(input));
        }
        readPost(root);
    }

    static void readPost(Node node) {
        if(node == null) return;
        readPost(node.left);
        readPost(node.right);
        System.out.println(node.val);
    }
}
