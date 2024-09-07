class employee{
    int id;
    int salary;
    String name;
    public void getDetails(){
        System.out.println(id);
        System.out.println(name);
    }
    public void getSalary(){
        System.out.println(salary);
    }

}
public class ownclass {
    public static void main(String []args){
    System.out.println("COMPANY");
    employee stark=new employee();
    employee steve=new employee();
    stark.id=1;
    stark.salary=10;
    stark.name="STARK";

    steve.id=2;
    steve.salary=5;
    steve.name="STEVE";

    stark.getDetails();
    stark.getSalary();
    steve.getDetails();
    steve.getSalary();

}
}