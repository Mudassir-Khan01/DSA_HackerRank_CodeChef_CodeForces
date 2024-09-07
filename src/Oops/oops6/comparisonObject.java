package Oops.oops6;

public class comparisonObject implements Comparable<comparisonObject>{
    int roll;
    int marks;
    public comparisonObject(int roll, int marks){
        this.roll=roll;
        this.marks=marks;
    }

    @Override
    public String toString() {
        return marks+"";
    }

    @Override
    public int compareTo(comparisonObject o) {
        int diff=(int)(this.marks-o.marks);
         //if diff=0 means both are equal
        //if diff is less than 0 measn o is bigger else o is smaller
        return diff;
    }
}
