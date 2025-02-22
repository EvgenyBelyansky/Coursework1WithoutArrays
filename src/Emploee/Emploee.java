package Emploee;

import java.util.Objects;
import java.util.UUID;

public class Emploee {
    private String firstName;
    private String middleName;
    private String lastName;
    private int department;
    private double salary;
    private int id;
    public static int count = 1;

    public Emploee(String lastName, String firstName, String middleName, int department, double salary) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.department = department;
        this.salary = salary;
        this.id = count;
        count++;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public int getCount() {
        return count;
    }

    public int getId(UUID emploeeId) {
        return id;
    }

    public void setDepartment(int department) {
        if (department >= 1 && department <= 5) {
            this.department = department;
        } else {
            throw new IllegalArgumentException("Такого департамента не существует");
        }
    }

    public void setSalary(double salary) {
        if (salary > 0) {
            this.salary = salary;
        } else if (salary < 0) {
            throw new IllegalArgumentException("Зарплата не может быть меньше или равна нулю");
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Emploee emploee = (Emploee) o;
        return department == emploee.department && salary == emploee.salary && id == emploee.id &&
                Objects.equals(firstName, emploee.firstName) &&
                Objects.equals(middleName, emploee.middleName) &&
                Objects.equals(lastName, emploee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, middleName, lastName, department, salary, id);
    }

    @Override
    public String toString() {
        return String.format("%s %s %s; Отдел: %s; Зарплата: %s; Id: %s.",
                lastName, firstName, middleName, department, salary, id);
    }

    public String getEmploeeFullName() {
        return String.format("%s %s %s",
                lastName, firstName, middleName);
    }

    public String getEmploeeWithoutDepartment() {
        return String.format("ФИО: %s %s %s; ЗП: %s; id %s.",
                lastName, firstName, middleName, salary, id);
    }
}
