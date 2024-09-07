package Oops;

public class _2innerclass {
    static class test{//not dependent on outer
        // OOps2_inner...
        //but it may depemd on psmv so 2 object will create and kunal and rahul both will print
        String name;
        public test(String name){
            this.name=name;
        }

    }

    public static void main(String[] args) {
        test a=new test("Kunal");
        test b=new test("Rahul");
        System.out.println(a.name);
        System.out.println(b.name);
    }
}
