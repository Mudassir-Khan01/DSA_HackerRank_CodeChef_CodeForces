import java.util.ArrayList;

public class maze_3includingDiag {
    public static void main(String[] args) {
path("",3,3);
        System.out.println(patharr("",3,3));
    }
    static void path(String p, int r, int c) {
        if (r == 1 && c == 1) {
            System.out.println(p);
            return;
        }
        if(c>1&&r>1){//D is diagnoal
            path(p+'D',r-1,c-1);
        }
        if (r > 1) {//agar row bada so go down
            path(p + 'V', r - 1, c);
        }
        if (c > 1) {//agar col bada so go right
            path(p + 'H', r, c - 1);
        }
    }
    //using arraylist

    static ArrayList<String> patharr(String p, int r, int c) {
        if (r == 1 && c == 1) {
            ArrayList<String>list=new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String>list=new ArrayList<>();
        if(c>1&&r>1){//D is diagnoal
            list.addAll(patharr(p+'D',r-1,c-1));
        }
        if (r > 1) {//agar row bada so go down
            list.addAll(patharr(p + 'V', r - 1, c));
        }
        if (c > 1) {//agar col bada so go right
            list.addAll(patharr(p + 'H', r, c - 1));
        }
        return list;
    }
}
