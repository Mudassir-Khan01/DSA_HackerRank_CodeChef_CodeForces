import java.util.ArrayList;

public class maze_2printingPath {
    public static void main(String[] args) {
path("",3,3);
        System.out.println(patharr("",3,3));
    }

    static void path(String p, int r, int c) {
        if (r == 1 && c == 1) {
            System.out.println(p);
            return;
        }
        if (r > 1) {//agar row bada so go down
            path(p + 'D', r - 1, c);
        }
        if (c > 1) {//agar col bada so go right
            path(p + 'R', r, c - 1);
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
        if (r > 1) {//agar row bada so go down
            list.addAll(patharr(p + 'D', r - 1, c));
        }
        if (c > 1) {//agar col bada so go right
            list.addAll(patharr(p + 'R', r, c - 1));
        }
        return list;
    }
}


