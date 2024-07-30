package src.main.kotlin.leetcode;


import java.util.*;

class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

public class CloneGraph {
    public Node cloneGraph(Node node) {
        if (node==null){
            return null;
        }
        Queue<Node> q =new LinkedList<>();
        HashMap<Node,Node> map = new HashMap<>();
        map.put(node,new Node(node.val));
        q.add(node);
        while (!q.isEmpty()){
            Node parent = q.poll();
            for (Node adjacent:parent.neighbors){
                if (!map.containsKey(adjacent)){
                    map.put(adjacent,new Node(adjacent.val));
                    q.add(adjacent);
                }
                map.get(parent).neighbors.add(map.get(adjacent));
            }
        }
        return map.get(node);
    }
}
