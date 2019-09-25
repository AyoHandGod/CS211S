package module2;

import java.util.ArrayList;
import java.util.List;

public class Department {

    private List<Employee> employeeList;

    public Department() {
        employeeList = new ArrayList<>();
    }

    public void addEmployee(Employee e) {
        employeeList.add(e);
    }

    public void addEmployee(String type, int id){

    }

}
