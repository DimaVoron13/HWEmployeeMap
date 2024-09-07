package HWEmployeeMap.HWEmployee;

public interface EmployeeServise {
    String addEmployee(String firstName, String lastName);

    String findEmployee(String firstName, String lastName);

    String delEmployee(String firstName, String lastName);

    void employeesAbOvo();
}
