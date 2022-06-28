import java.util.*;

class Solution {
    static class Node implements Comparable<Node>{
        int id, y, x;
        Node left, right;
        Node(int id, int y, int x, Node left, Node right){
            this.id=id;
            this.y=y;
            this.x=x;
            this.left=left;
            this.right=right;
        }
        @Override
        public int compareTo(Node o){
            if (this.y==o.y) return this.x-o.x;
            return o.y-this.y;
        }
    }
    int pre_cnt=0;
    int post_cnt=0;
    int[][] answer = new int[2][];
    public int[][] solution(int[][] nodeinfo) {
        Node[] nodes=new Node[nodeinfo.length];
        answer[0]=new int[nodeinfo.length];
        answer[1]=new int[nodeinfo.length];
        for (int i=0; i<nodeinfo.length; i++){
            nodes[i]=new Node(i+1, nodeinfo[i][1], nodeinfo[i][0], null, null);
        }
        Arrays.sort(nodes);
        for (int i=1; i<nodeinfo.length; i++){
            makeTree(nodes[0], nodes[i]);
        }
        preOrder(nodes[0]);
        postOrder(nodes[0]);
        return answer;
    } 
    
    void makeTree(Node parent, Node child){
        if (parent.x<child.x){		// 오른쪽 subtree
            if (parent.right==null) parent.right=child;
            else makeTree(parent.right, child);
        }
        else{					//왼쪽 subtree
            if (parent.left==null) parent.left=child;
            else makeTree(parent.left, child);
        }
    }
    
    void preOrder(Node now){
        if (now==null) return;
        answer[0][pre_cnt++]=now.id;
        preOrder(now.left);
        preOrder(now.right);
    }
    
    void postOrder(Node now){
        if (now==null) return;
        postOrder(now.left);
        postOrder(now.right);
        answer[1][post_cnt++]=now.id;
    }
    
    
}
