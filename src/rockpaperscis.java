import java.util.Random;
import java.util.Scanner;
public class rockpaperscis {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i,a=0,b=0;
        for (i=1;i<=5;i++) {
            System.out.print("Enter 0 for Rock,1 for Paper,2 for Scissor: ");
            int num1 = sc.nextInt();
            Random x = new Random();
            int num2 = x.nextInt(3);
            switch (num1) {
                case 0 : System.out.println("User->Rock");break;
                case 1 : System.out.println("User->Paper");break;
                case 2 : System.out.println("User->Scissor");break;
            }
            switch (num2) {
                case 0 : System.out.println("User->Rock");break;
                case 1 : System.out.println("User->Paper");break;
                case 2 : System.out.println("User->Scissor");break;
            }
            if (num1 == 0 && num2 == 0) {
                System.out.println("draw");
            }
            else if (num1 == 1 && num2 == 1) {
                System.out.println("draw");
            }
            else if (num1 == 2 && num2 == 2) {
                System.out.println("draw");
            }
            else if (num1 == 0 && num2 == 1) {
                System.out.println("You loose");
                b=b+1;
            }
            else if (num1 == 1 && num2 == 2) {
                System.out.println("You loose");
                b=b+1;
            }
            else if (num1 == 2 && num2 == 0) {
                System.out.println("You loose");
                b=b+1;
            }
            else if (num1 == 1 && num2 == 0) {
                System.out.println("You win");
                a=a+1;
            }
            else if (num1 == 0 && num2 == 2) {
                System.out.println("You win");
                a=a+1;
            }
            else if (num1 == 2 && num2 == 1) {
                System.out.println("You win");
                a=a+1;
            }
            else {
                System.out.println("Wrong input");
            }
            System.out.println("You total score is: "+a);
            System.out.print("Computer total score is: "+b);
            if (a>b){
                System.out.println("You won!");
            } else if (a==b) {
                System.out.println("Draw!");
            }
            else {
                System.out.println("You lost!");
            }
        }
    }
}

