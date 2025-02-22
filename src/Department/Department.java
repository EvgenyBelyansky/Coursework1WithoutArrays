package Department;

import Emploee.Emploee;

import java.util.*;
import java.util.stream.Collectors;

public class Department {

    private final Map<UUID, Emploee> emploees;

    private final DepartmentType departmentType;

    public Department(DepartmentType departmentType) {
        this.emploees = new HashMap<>();
        this.departmentType = departmentType;
    }

    public UUID addEmploee(Emploee emploee) {
        UUID id = UUID.randomUUID();
        emploees.put(id, emploee);
        return id;
    }

    public Emploee removeEmployee(UUID id) {
        return emploees.remove(id);
    }

    public DepartmentType getDepartmentType() {
        return departmentType;
    }

    public Emploee findEmploeeWithMaxSalaryInDepartment() {
        return emploees.values().stream()
                .max(Comparator.comparingDouble(Emploee::getSalary))
                .orElseThrow();
    }

    public Emploee findEmploeeWithMinSalaryInDepartment() {
        return emploees.values().stream()
                .min(Comparator.comparingDouble(Emploee::getSalary))
                .orElseThrow();
    }

    public double calculateSumSalariesPerMonthOfDepartment() {
        return emploees.values().stream()
                .mapToDouble(e -> e.getSalary())
                .sum();
    }

//    public Integer getEmploeesSizeInDepartment() {
//        return emploees.size();
//    }

    public double calculateAverageSalaryOfDepartment() {
        return emploees.values().stream()
                .collect(Collectors.averagingDouble(Emploee::getSalary));

//        2й вариант(был сначала)
//        return calculateSumSalariesPerMonthOfDepartment() / emploees.size();
    }

    public void indexSalaryEmploeeOfDepartment(final double percent) {
        emploees.values().forEach(value -> value.setSalary((value.getSalary() * percent / 100) + value.getSalary()));
    }

    public void printAllEmploeesOfDepartment() {
        System.out.printf("\nСписок всех сотрудников в отделе - %s:", departmentType.getValue());
        emploees.values()
                .forEach(value -> System.out.println(value.getEmploeeWithoutDepartment()));
    }

    public void printAllFullNamesEmploeesOfDepartment() {
        System.out.printf("Список сотрудников %s отдела:%n", departmentType.getValue());
        for (Emploee value : emploees.values()) {
            System.out.println(value.getEmploeeFullName());
        }
    }

    public void findAndPrintEmploeesWithSalaryLessThanInDepartment(double baseSalary) {
        emploees.values().stream()
                .filter(emploee -> emploee.getSalary() < baseSalary)
                .forEach(emploee -> System.out.printf("\n%s", emploee.getEmploeeWithoutDepartment()));
    }

    public Emploee findEmploeeInDepartmentByID(final UUID id) {
        return emploees.get(id);
    }
}