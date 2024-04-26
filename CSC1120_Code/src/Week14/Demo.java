package Week14;



public class Demo {
    public static void main(String[] args) {
        Address address = new Address("New York", "NY");
        Employee originalEmployee = new Employee("John Doe", 30, address);

        // Shallow copy
        Employee shallowCopy = originalEmployee;
        shallowCopy.setName("Jane Smith");
        shallowCopy.getAddress().setCity("Los Angeles");
        System.out.println(originalEmployee.getAddress().getCity());


        // Deep copy
        Employee deepCopy = null;
        try {
            deepCopy = (Employee) originalEmployee.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        deepCopy.setName("Alice Johnson");
        deepCopy.getAddress().setCity("Chicago");

        // Output
        System.out.println("Original Employee: " + originalEmployee.getName() + ", " +
                originalEmployee.getAddress().getCity());
        System.out.println("Shallow Copy: " + shallowCopy.getName() + ", " +
                shallowCopy.getAddress().getCity());
        System.out.println("Deep Copy: " + deepCopy.getName() + ", " +
                deepCopy.getAddress().getCity());
    }
}
