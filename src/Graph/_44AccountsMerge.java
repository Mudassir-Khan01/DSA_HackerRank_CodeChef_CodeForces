package Graph;

import java.util.*;

public class _44AccountsMerge {
    static List<List<String>> accountsMerge(List<List<String >> details){
        int n=details.size();
        DisjointSet ds=new DisjointSet(n);
        HashMap<String,Integer> mapMAilNode=new HashMap<String,Integer>();
        for(int i=0;i<n;i++){//i is the node
            for (int j=1;j<details.get(i).size();j++){//starting from 1 as 0th contains name
                String mail=details.get(i).get(j);
                if(mapMAilNode.containsKey(mail)==false){//it doesnt contain that mail
                    mapMAilNode.put(mail,i);//just put it in the hashmap (mail->0)
                }else {//if that mail is already seen
                    ds.unionBySize(i,mapMAilNode.get(mail));
                }//so for disjoint set and map is created
            }
        }
       //now its your job to take those map and put it in a list of merged string of mail
        ArrayList<String>[] mergedMail=new ArrayList[n];
        for(int i=0;i<n;i++) {
            mergedMail[i] = new ArrayList<String>();
        }
            for(Map.Entry<String,Integer> it:mapMAilNode.entrySet()){
            String mail=it.getKey();//get the mail
            int node=ds.findUPar(it.getValue());//find node or ultimate parent
            mergedMail[node].add(mail);//and merge the node with the mist of mails here its{0,mail}
            }
            //third steps
        List<List<String >> ans=new ArrayList<>();
            for(int i=0;i<n;i++){
                if(mergedMail[i].size()==0){
                    continue;
                }
                Collections.sort(mergedMail[i]);
                List<String> temp=new ArrayList<>();
                temp.add(details.get(i).get(0));//first add the name at 0 all the names will be there
                for (String it:mergedMail[i]){
                    temp.add(it);//adding the mails of that particular mail
                }
                ans.add(temp);//at the ned adding all the name
            }
            return ans;
    }
    public static void main (String[] args) {
        List<List<String>> accounts = new ArrayList() {
            {
                add(new ArrayList<String>(Arrays.asList("John", "j1@com", "j2@com", "j3@com")));
                add(new ArrayList<String>(Arrays.asList("John", "j4@com")));
                add(new ArrayList<String>(Arrays.asList("Raj", "r1@com", "r2@com")));
                add(new ArrayList<String>(Arrays.asList("John", "j1@com", "j5@com")));
                add(new ArrayList<String>(Arrays.asList("Raj", "r2@com", "r3@com")));
                add(new ArrayList<String>(Arrays.asList("Mary", "m1@com")));

            }
        };

        _44AccountsMerge obj = new _44AccountsMerge();
        List<List<String>> ans = obj.accountsMerge(accounts);

        int n = ans.size();
        for (int i = 0; i < n; i++) {
            System.out.print(ans.get(i).get(0) + ": ");
            int size = ans.get(i).size();
            for (int j = 1; j < size; j++) {
                System.out.print(ans.get(i).get(j) + " ");
            }

            System.out.println("");
        }

    }
}
