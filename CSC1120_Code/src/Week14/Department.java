package Week14;

public class Department
{
    private int id;
    private String name;

    public Department(int id, String name)
    {
        this.id = id;
        this.name = name;
    }

    //Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    // clone method
    //clone method is used to create a copy of an object


    @Override
    public String toString() {
        return "Department [id=" + id + ", name=" + name + "]";
    }
}