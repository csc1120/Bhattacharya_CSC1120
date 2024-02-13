package Week5;

// Java program to show multiple
// type parameters in Java Generics

// We use < > to specify Parameter type
// We can use multiple parameters by separating them with comma

class Demo<T, U, V> {
    T obj1; // An object of type T
    U obj2; // An object of type U
    V obj3; // An object of type V

    // constructor
    Demo(T obj1, U obj2, V obj3)
    {
        this.obj1 = obj1;
        this.obj2 = obj2;
        this.obj3 = obj3;
    }

    // To print objects of T, U, V
    public void print()
    {
        System.out.println(obj1);
        System.out.println(obj2);
        System.out.println(obj3);
    }
    // Create a generic method
    public <T> void genericDisplay(T element){
        System.out.println(element.getClass().getName());
    }
    // create an array of T type
    public <T> void genericArray(T[] elements){
        for (T element : elements){
            System.out.println(element);
        }
    }


//        System.out.println(obj2);
//        System.out.println(obj3);
   // }
//}
//{
//    T obj1; // An object of type T
//    U obj2; // An object of type U
//    // hav
//
//    // constructor
//    Test(T obj1, U obj2 )
//    {
//        this.obj1 = obj1;
//        this.obj2 = obj2;
//    }
//
//    // To print objects of T and U
//    public void print()
//    {
//        System.out.println(obj1);
//        System.out.println(obj2);
//    }
//}

// Driver class to test above

    public static void main (String[] args)
    {
        Demo<String, Integer, Double> obj =
                new Demo<String, Integer, Double>("GfG", 15, 20.99);
        // calling the method with Integer argument
        obj.genericDisplay(10);
        obj.print();
    }
}
