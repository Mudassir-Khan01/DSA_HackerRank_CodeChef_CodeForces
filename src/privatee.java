class employee1{
    private int id;
    private String name;
    public void setName(String n){
        name=n;
    }
    public String getName(){
        return name;
    }
    public void setId(int i){
        id=i;
    }
    public int getId(){
        return id;
    }


}
public class privatee {
    public static void main(String[]args){
employee1 stark=new employee1();
stark.setName("STARK");
System.out.println(stark.getName());
stark.setId(131);
System.out.println(stark.getId());
    }
}
