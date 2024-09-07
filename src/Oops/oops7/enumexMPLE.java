package Oops.oops7;

public class enumexMPLE {
    enum Week{
        Monday,Tuesday,Wednesday,Thursday,Friday,Saturday,Sunday
        //these are enum constant
        //public ,static , final
        //since its final u cant create child enums
    }

    public static void main(String[] args) {
        Week week=Week.Monday;
        System.out.println(week);
        System.out.println(week.ordinal());//position of that day
        //or
        for(Week day:Week.values()){
            System.out.println(day);
        }
    }
}
