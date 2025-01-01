

import java.io.*;
import java.util.*;

class Node {
    char value;
    Node left;
    Node right;

    public Node(char value){
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

public class Main {

    public static void preorder(Node node){
        if(node==null) return;
        System.out.print(node.value);
        preorder(node.left);
        preorder(node.right);
    }

    public static void inorder(Node node){
        if(node==null) return;
        inorder(node.left);
        System.out.print(node.value);
        inorder(node.right);
    }

    public static void postorder(Node node){
        if(node==null) return;
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.value);
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Node[] tree = new Node[N+1];

        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            char parent = st.nextToken().charAt(0);
            char childL = st.nextToken().charAt(0);
            char childR = st.nextToken().charAt(0);

            // 부모 노드 아직 미생성
            if(tree[parent-'A']==null){
                tree[parent-'A'] = new Node(parent);
            }

            // 왼쪽 자식 존재
            if(childL != '.'){
                tree[childL-'A'] = new Node(childL); // 왼쪽 자식 노드 생성
                tree[parent-'A'].left = tree[childL-'A']; // 부모 노드와 연결
            }

            // 오른쪽 자식 존재
            if(childR != '.'){
                tree[childR-'A'] = new Node(childR); // 오른쪽 자식 노드 생성
                tree[parent-'A'].right = tree[childR-'A'];
            }

            
        }
        preorder(tree[0]);
        System.out.println();

        inorder(tree[0]);
        System.out.println();

        postorder(tree[0]);

    }
}
