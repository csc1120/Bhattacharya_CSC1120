package Week14;



class Employee implements Cloneable {
    private String name;
    private int age;
    private Address address;

    public Employee(String name, int age, Address address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    // Deep copy constructor
    public Employee(Employee employee) {
        this.name = employee.name;
        this.age = employee.age;
        this.address = new Address(employee.address);
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    // Override clone method for deep copy
    @Override
    public Object clone() throws CloneNotSupportedException {
        Employee clonedEmployee = (Employee) super.clone();
        clonedEmployee.address = (Address) address.clone();
        return clonedEmployee;
    }
}