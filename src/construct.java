class employee2{
    private int id;
    private String name;

    public employee2(int i , String myname){
      id=i;
      name=myname;
    }
    public String getName(){
        return name;
    }
    public int getId(){
        return id;
    }

}
public class construct {
    public static void main(String[]args){
employee2 stark=new employee2(1,"TONY_STARK");
    System.out.println(stark.getId());
    System.out.println(stark.getName());

    }
}
