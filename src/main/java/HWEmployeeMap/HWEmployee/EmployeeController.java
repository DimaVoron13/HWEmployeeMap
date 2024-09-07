package HWEmployeeMap.HWEmployee;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/person")
public class EmployeeController {
    EmployeeServiceImpl serv = new EmployeeServiceImpl();

    {
        serv.employeesAbOvo();
    }

    @GetMapping("/add")
    public String addPerson(@RequestParam("firstName") String firstName,
                            @RequestParam("lastName") String lastName) {
        try {
            return serv.addEmployee(firstName, lastName);
        } catch (EmployeeAlreadyAddedException e) {
            return "Такой сотрудник уже существует.";
        } catch (EmployeeStorageIsFullException e) {
            return "Нельзя добавить сотрудника, полный штат.";
        } catch (BadRequestException e) {
            return "BadRequestException";
        }
    }

    @GetMapping("/del")
    public String delPerson(@RequestParam("firstName") String firstName,
                            @RequestParam("lastName") String lastName) {
        try {
            return serv.delEmployee(firstName, lastName);
        } catch (EmployeeNotExistException e) {
            return "Такого сотрудника в штате нет.";
        }
    }

    @GetMapping("/find")
    public String findPerson(@RequestParam("firstName") String firstName,
                             @RequestParam("lastName") String lastName) {
        try {
            return serv.findEmployee(firstName, lastName);
        } catch (EmployeeNotExistException e) {
            return "Такого сотрудника в штате нет.";
        }
    }

    @GetMapping("/list")
    public Map listEmployee() {
        return serv.listOfEmployee();
    }
}
