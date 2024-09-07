package HWEmployeeMap.HWEmployee;

import java.util.Objects;

public class Employee {

    private String firstName;
    private String lastName;
    private static int countId = 0;
    private int id;

    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.countId++;
        this.id = countId;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public Integer getId() {
        return this.id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return this.firstName + " " + this.lastName + " ";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (this.hashCode() != obj.hashCode()) {
            return false;
        }
        if (this.getClass() != obj.getClass() || obj == null) return false;
        return (this.firstName.equals(((Employee) obj).getFirstName()) &&
                this.lastName.equals(((Employee) obj).getLastName()));
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }
}
