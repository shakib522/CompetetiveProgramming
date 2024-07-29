package src.main.kotlin.leetcode;

import java.util.*;

public class AccountsMerge {
    public static void main(String[] args) {

    }
    int findParent(int[] parent,int toFind){
        while(parent[toFind]!=toFind){
            toFind=parent[toFind];
        }
        return toFind;
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        Map<String,Integer> emailGroup = new HashMap<>();
        int accountListSize = accounts.size();
        int[] parent = new int[1001];
        for (int i=0;i<accountListSize;i++){
            parent[i]=i;
            int accountSize = accounts.get(i).size();
            for (int j=1;j<accountSize;j++){
                if (emailGroup.containsKey(accounts.get(i).get(j))){
                    int parent1=findParent(parent,i);
                    int parent2=findParent(parent,emailGroup.get(accounts.get(i).get(j)));
                    parent[parent1]=parent2;
                }else{
                    emailGroup.put(accounts.get(i).get(j),i);
                }
            }
        }
        Map<Integer,List<String>> result = new HashMap<>();
        for (int i=0;i<accountListSize;i++){
            result.put(i,new ArrayList<>());
        }
        for (String key:emailGroup.keySet()){
            int id=emailGroup.get(key);
            int uniqueId=findParent(parent,id);
            result.get(uniqueId).add(key);
        }
        List<List<String>> ans = new ArrayList<>();
        for (Integer key:result.keySet()){
            List<String> email = new ArrayList<>(result.get(key));
            Collections.sort(email);
            email.add(0, accounts.get(key).get(0));
            ans.add(email);
        }
        List<List<String>> ans2 = new ArrayList<>();
        for (List<String> an : ans) {
            if (an.size() > 1) {
                ans2.add(an);
            }
        }
        return ans2;
    }
}
