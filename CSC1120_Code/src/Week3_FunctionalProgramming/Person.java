package Week3_FunctionalProgramming;

public class Person {
    private   String name;
    private   String major;


    public  Person(String name, String major){
        this.name= name;
        this.major= major;
    }

    public  String getName() {
        return name;
    }

    public  String getMajor() {
        return major;
    }

    @Override
    public  String toString(){
        return "Person{"+
                "name = '"+ name+'\''+
                ", major = "+major +
                ",}";
    }



}
