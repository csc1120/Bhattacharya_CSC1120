package Week11;
public class Hash_Driver {
    public static void main(String[] args) {
        //character 1
        Character1 character1 = new Character1("Arnold");
        System.out.println(character1.getName());
        System.out.println(character1.hashCode());
        Character1 character2 = new Character1("Arnold");
        System.out.println(character2.getName());
        System.out.println(character2.hashCode());
        System.out.println(character2.equals(character1));

        // Character 2
        Character2 character3 = new Character2("Arnold");
        System.out.println(character3.getName());
        System.out.println(character3.hashCode());
        Character2 character4 = new Character2("Arnold");
        System.out.println(character4.getName());
        System.out.println(character4.hashCode());
        System.out.println(character4.equals(character3));

    }
}
