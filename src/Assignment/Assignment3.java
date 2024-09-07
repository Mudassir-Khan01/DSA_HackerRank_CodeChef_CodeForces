package Assignment;

import java.util.Arrays;
import java.util.Scanner;

public class Assignment3 {
    public static void main(String[] args) {
        int Student=10;
        Scanner sc=new Scanner(System.in);
        String []names=new String[Student];
        int []RollNo=new int[Student];
        int [] grades=new int [Student];
        //NAMES
        System.out.println("Enter 10 names");
        for(int i=0;i<Student;i++){
            names[i]= sc.next();
        }
        System.out.println("Student Names are :"+Arrays.toString(names));
        //Roll No.
        System.out.println("Enter their respective roll numbers");
        for(int i=0;i<Student;i++){
            RollNo[i]= sc.nextInt();
        }
        System.out.println(" Roll Number :"+Arrays.toString(RollNo));
        //GRADES
        System.out.println("Enter their grades");
        for(int i=0;i<Student;i++){
            grades[i]= sc.nextInt();
        }
        System.out.println(" Grades :"+Arrays.toString(grades));
    }
}

