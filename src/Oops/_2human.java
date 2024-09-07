package Oops;

public class _2human {
    int age;
    String name;
    int slaalry;
    boolean married;
    static long population;//common for both human we used static

    public _2human(int age, String name, int salary, boolean marrued) {
        this.age = age;
        this.name = name;
        this.slaalry = salary;
        this.married = marrued;
       _2human.population += 1;//can write it OOPS2_human.population
    }
}
