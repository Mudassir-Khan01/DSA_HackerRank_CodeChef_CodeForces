package Linked_List.Questions;

public class _7HappyNumber {
    public boolean isHappy(int n){
        int slow=n;
        int fast=n;
        do{
            slow=findSquare(slow);
            fast=findSquare(findSquare(fast));

        }while(slow!=fast);
        if(slow==1){
            return true;
        }
        return false;
    }
    private int findSquare(int number){
        int ans=0;
        while(number>0){
            int rem=number%10;
            ans=ans+(rem*rem);
            number=number/10;
        }
        return ans;
    }

    public static void main(String[] args) {
        _7HappyNumber happy=new _7HappyNumber();//above one is
        System.out.println(happy.isHappy(19));
    }
}
