public class methoverload {
    static void foo(){
        System.out.println("Hii There");
    }
    static void foo(int a){
        System.out.println("Hii There "+a);
    }
    static void foo(int a , int b){
        System.out.println("Hii there "+a+" " +b);
    }
    public static void main(String[] args){
        foo();
        foo(3000);
        //foo(3000,3000);

    }
}
