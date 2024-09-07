package Oops;

public class _2main {

    public static void main(String[]args){
        _2human kunal=new _2human(22,"Kunal",100,false);
        _2human rahul=new _2human(23,"Rahul",2000,true);
        _2human mudassir=new _2human(19,"Mudassir",1000000,false);
        System.out.println(kunal.population);
        System.out.println(rahul.population);
        System.out.println(mudassir.population);
        //without cretaing the object we can still use static and using classname.population in sopln

    }

}
