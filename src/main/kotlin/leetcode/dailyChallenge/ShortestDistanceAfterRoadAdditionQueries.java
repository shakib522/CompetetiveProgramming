package src.main.kotlin.leetcode.dailyChallenge;

import java.util.*;


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

public class ShortestDistanceAfterRoadAdditionQueries {
    public static void main(String[] args) {
//        shortestDistanceAfterQueries(5,new int[][]{
//                {2,4},
//                {0,2},
//                {0,4}
//        });
    }
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n-1; i++) {
            list.add(new ArrayList<>());
            list.get(i).add(i+1);
        }
        list.add(new ArrayList<>());
        int[] ans=new int[queries.length];
        System.out.println(list);
        for (int i = 0; i < queries.length; i++) {
            list.get(queries[i][0]).add(queries[i][1]);
            ans[i]=dijkstra(list,n);
        }
        return ans;
    }
    int dijkstra(List<List<Integer>>list,int v){
        int[] distance=new int[v];
        Comparator<Pairs<Integer,Integer>> cmp=new Comparator<Pairs<Integer, Integer>>() {
            @Override
            public int compare(Pairs<Integer, Integer> o1, Pairs<Integer, Integer> o2) {
                return o1.getFirst()-o2.getFirst();
            }
        };
        Arrays.fill(distance,1000000000);
        PriorityQueue<Pairs<Integer,Integer>> pq = new PriorityQueue<>();
        distance[0]=0;
        pq.add(new Pairs<>(0,0));
        while (!pq.isEmpty()){
            Pairs<Integer,Integer> val=pq.poll();
            int dis=val.getFirst();
            int node=val.getSecond();
            for(int it : list.get(node)){
                int edgeWeight=1;
                int adjNode=it;
                if (dis+edgeWeight<distance[adjNode]){
                    distance[adjNode]=dis+edgeWeight;
                    pq.add(new Pairs<>(distance[adjNode],adjNode));
                }
            }
        }
        return distance[v-1];
    }
}
