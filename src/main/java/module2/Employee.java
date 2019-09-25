package module2;

public abstract class Employee implements Comparable<Employee> {

    private int id;

    private static int numEmployees = 0;
    private static final int DEFAULT_ID = 0;

    private Employee(int id){
        this.id = id;
        Employee.numEmployees++;
    }

    public Employee() {
        this(DEFAULT_ID);
    }

    public int getId() {
        return this.id;
    }

}
