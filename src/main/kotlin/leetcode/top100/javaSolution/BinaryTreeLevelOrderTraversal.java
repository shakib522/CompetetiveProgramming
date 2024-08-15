package src.main.kotlin.leetcode.top100.javaSolution;

import src.main.kotlin.Pair;



import java.util.*;
  class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
     TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root==null){
            return Collections.emptyList();
        }
        Queue<Pair<TreeNode,Integer>> q = new LinkedList<>();
        Map<Integer,List<Integer>> map = new LinkedHashMap<>();
        q.add(new Pair<>(root,0));
        while (!q.isEmpty()){
            TreeNode node = q.peek().getFirst();
            Integer level = q.peek().getSecond();
            q.poll();
            if(!map.containsKey(level)){
                map.put(level,new ArrayList<>());
            }
            map.get(level).add(node.val);
            if(node.left!=null){
                q.add(new Pair<>(node.left,level+1));
            }
            if(node.right!=null){
                q.add(new Pair<>(node.right,level+1));
            }
        }
        return new ArrayList<>(map.values());
    }
}