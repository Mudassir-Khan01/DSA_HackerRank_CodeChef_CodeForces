package Graph;

import java.util.ArrayList;
import java.util.List;

public class _39DisjointSet1 {
    List<Integer> rank=new ArrayList<>();
    List<Integer> parent=new ArrayList<>();
    public _39DisjointSet1(int n){
        for(int i=0;i<=n;i++){
            rank.add(0);
            parent.add(i);
        }
    }
    public int findUPar(int node){
        if(node==parent.get(node)){
            return node;
        }
        int ulp=findUPar(parent.get(node));//Path Compression
        parent.set(node,ulp);//make it directly attack to its ultimate parent
        return parent.get(node);
    }
    public void unionByRank(int u,int v){
        int ulp_u=findUPar(u);
        int ulp_v=findUPar(v);
        if(ulp_u==ulp_v) return;
        if(rank.get(ulp_u)<rank.get(ulp_v)){
            parent.set(ulp_u,ulp_v);//(child ,parent)
        }else if(rank.get(ulp_v)<rank.get(ulp_u)){
            parent.set(ulp_v,ulp_u);
        }
        else {
            parent.set(ulp_v,ulp_u);//if same rank then attach in any manner
            int rankU=rank.get(ulp_u);
            rank.set(ulp_u,rankU+1);
        }
    }

    public static void main(String[] args) {
        _39DisjointSet1 ds = new _39DisjointSet1(7);
        ds.unionByRank(1, 2);
        ds.unionByRank(2, 3);
        ds.unionByRank(4, 5);
        ds.unionByRank(6, 7);
        ds.unionByRank(5, 6);

        //is 3 and 7 are same or not
        if (ds.findUPar(3) == ds.findUPar(7)) {
            System.out.println("Same");
        } else {
            System.out.println("Not same");
        }
        ds.unionByRank(3, 7);
        if (ds.findUPar(3) == ds.findUPar(7)) {
            System.out.println("Same");
        } else {
            System.out.println("Not same");
        }
    }
}
