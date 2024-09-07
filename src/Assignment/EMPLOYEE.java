package Assignment;

import java.util.Scanner;

public class EMPLOYEE {
    public static void main(String[] args) {
        int EmployeeId;
        String EmplyeeName;
        double BasicSalary;
        double DA;
        double IT;
        double NetSalary;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of employees");
        int n = sc.nextInt();
        for(int i=1;i<=n;i++){
            System.out.println("Enter the Name and Salary of Employee " +i);
            EmplyeeName = sc.next();
             BasicSalary =sc.nextInt();
            DA=0.25*BasicSalary;
            IT=0.3*BasicSalary;
            NetSalary=BasicSalary+DA-IT;
            System.out.println("Net Salary of "+EmplyeeName+" is "+NetSalary);
        }
    }
}


