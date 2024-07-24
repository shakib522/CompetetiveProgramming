package src.main.kotlin.leetcode.q75;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {
    public static void main(String[] args) {

    }

    public static List<Integer> rightSideView(TreeNodes root) {
        ArrayList<Pairs<Integer,Integer>> ans = new ArrayList<>();
        Queue<Pairs<TreeNodes,Integer>> q=new LinkedList<>();
        q.add(new Pairs<>(root,1));
        while (!q.isEmpty()) {
            Pairs<TreeNodes,Integer> node = q.poll();
            ans.add(new Pairs<>(node.getFirst().val,node.getSecond()));
            if (node.getFirst() == null){
                q.add(new Pairs<>(node.getFirst().right,node.getSecond()+1));
            }
            if (node.getFirst().left!=null){
                q.add(new Pairs<>(node.getFirst().left, node.getSecond() +1));
            }
        }
        for (Pairs<Integer, Integer> an : ans) {
            System.out.println(an.getFirst() + " " + an.getSecond());
        }
        return null;
    }
}


class TreeNodes {
    int val;
    TreeNodes left;
    TreeNodes right;

    TreeNodes() {
    }

    TreeNodes(int val) {
        this.val = val;
    }

    TreeNodes(int val, TreeNodes left, TreeNodes right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
class Pairs<T, U> {
    private T first;
    private U second;
    public Pairs(T first,U second){
        this.first=first;
        this.second=second;
    }
    public T getFirst(){
        return first;
    }
    public void setFirst(T first){
        this.first=first;
    }
    public U getSecond(){
        return second;
    }
    public void setSecond(U second){
        this.second = second;
    }
}