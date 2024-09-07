package HWEmployeeMap.HWEmployee;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeServiceImpl {
    int maxEmploee = 15;
    Map<Employee, Integer> employees = new HashMap<>();

    public String addEmployee(String firstName, String lastName) throws EmployeeAlreadyAddedException {
        if (firstName.isEmpty() || lastName.isEmpty()) {
            throw new BadRequestException();
        }
        Employee temp = new Employee(firstName, lastName);
        String word = "";
        if (employees.size() >= maxEmploee) {
            throw new EmployeeStorageIsFullException();
        }
        if (employees.containsKey(temp)) {
            throw new EmployeeAlreadyAddedException();
        } else {
            employees.put(temp, temp.getId());
            word = "Success, сотрудник " + temp.toString() + ", id = " + temp.getId() + " добавлен.";
        }
        return word;
    }

    public String findEmployee(String firstName, String lastName) {
        Employee temp = new Employee(firstName, lastName);
        if (!employees.containsKey(temp)) {
            throw new EmployeeNotExistException();
        } else {
            return "Сотрудник " + temp.toString() + ", id = " + employees.get(temp) + " находится в штате.";
        }
    }

    public String delEmployee(String firstName, String lastName) {
        Employee temp = new Employee(firstName, lastName);
        if (!employees.containsKey(temp)) {
            throw new EmployeeNotExistException();
        } else {
            employees.remove(temp);
            return "Сотрудник " + temp.toString() + " удален из списка.";
        }
    }

    public Map listOfEmployee() {
        return employees;
    }

    public void employeesAbOvo() {
        Employee temp = new Employee("Андрицкая", "Светлана");
        buildEmployee(temp);
        temp = new Employee("Соболева", "Елена");
        buildEmployee(temp);
        temp = new Employee("Некрасова", "Олеся");
        buildEmployee(temp);
        temp = new Employee("Стяжкина", "Надежда");
        buildEmployee(temp);
        temp = new Employee("Лампель", "Екатерина");
        buildEmployee(temp);
        temp = new Employee("Смирнов", "Евгений");
        buildEmployee(temp);
        temp = new Employee("Леуский", "Владислав");
        buildEmployee(temp);
    }

    public void buildEmployee(Employee temp) {
        employees.put(temp, temp.getId());
    }
}
