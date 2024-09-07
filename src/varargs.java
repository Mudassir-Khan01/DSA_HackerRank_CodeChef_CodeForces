public class varargs {
    static int sum(int ...arr){
        int result=0;
        for(int a:arr){
            result +=a;
        }
        return result;
    }
    public static void main(String []args) {
        System.out.println("Variable arguments");
        System.out.println("\t"+sum(4, 5));
        System.out.println("\t"+sum(4, 3, 5));
        System.out.println("\t"+sum(2, 4, 3, 5));
    }
    }


