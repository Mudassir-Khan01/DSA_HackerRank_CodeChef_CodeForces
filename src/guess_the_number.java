import java.util.Scanner;
import java.util.Random;
class game {
    private int comp;
    private int guess = 0;
    Scanner sc = new Scanner(System.in);
    Random rn = new Random();

    public game() {
        comp = rn.nextInt(101);
    }

    public int userinput() {
        System.out.println("Type any number between 1-100");
        int user = sc.nextInt();
        return user;
    }

    public boolean iscorrect(int mynum) {
        int flag = 0;
        if (mynum <= 100 && mynum >= 0) {
            setguess();
            if (mynum == comp) {
                System.out.println("Correct Guess and the number is " + mynum);
                flag = 1;
                sc.close();
            } else if (mynum < comp) {
                System.out.println("Your number is less than the correct number");
            } else if (mynum > comp) {
                System.out.println("Your number is greater than the correct number");
            }

        } else {
            System.out.println("Please enter number between 1-100");
        }
        if (flag == 1) {
            return true;
        } else {
            return false;
        }
    }

    public void setguess() {
        guess++;
    }

    public void getguess() {
        System.out.println(guess);
    }
}
 public class guess_the_number {
    public static void main(String[]args){
        game mygame=new game();
        boolean playgame=true;
        int user;
        while(playgame==true){
            user=mygame.userinput();
            boolean mybool=mygame.iscorrect(user);
            if(mybool ==true) {
                System.out.print("Guessed in\t");
                mygame.getguess();
                System.out.println("guesses");
                System.out.println(" ");
                playgame = false;
                break;
            }
            else{
                playgame=true;
            }
        }
    }
}
