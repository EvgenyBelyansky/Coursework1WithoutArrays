package Company;

import Emploee.Emploee;

import java.util.LinkedHashMap;
import java.util.Map;

public class Company {

    private final Map<Integer, Department> departmentsMap = new LinkedHashMap<>();

//    private final Department.Department[] departments = new Department.Department[5];

    public int departmentSize() {
        int amount = 0;
        for (int i = 0; i < departmentsMap.size(); i++) {
            if (departmentsMap.get(i) != null) {
                amount++;
            }
        }
        return amount;
    }


    public void addDepartment(Integer departmentId , Department department) {
        departmentsMap.put(departmentId, department);



//        if (departmentSize() >= departments.length) {
//            throw new Company.CompanyFullException();
//        }
//        departments[departmentSize()] = department;
    }


    public void printAllEmploee() {
        System.out.println("\n\nСписок всех данных сотрудников:");
        for (int i = 0; i < departmentsMap.size(); i++) {
            departmentsMap.get(i).printAllEmploeesOfDepartment();
        }
    }

    public void addEmploee(Emploee emploee, int departmentNumber) {
        for (int i = 0; i < departmentsMap.size(); i++) {
            if (departmentNumber == departmentsMap.get(i).getDepartmentType()) {
                departmentsMap.get(i).addEmploee(emploee);
                break;
            }
        }
    }

    public void printFullNameEmploeeInCompany() {
        System.out.println("\n\nСписок сотрудников компании:");
        for (int i = 0; i < departmentsMap.size(); i++) {
            departmentsMap.get(i).printAllFullNamesEmploeesOfDepartment();
        }
    }

    public double calculateSumSalariesPerMonthInCompany() {
        double sum = 0;
        for (int i = 0; i < departmentsMap.size(); i++) {
            sum += departmentsMap.get(i).calculateSumSalariesPerMonthOfDepartment();
        }
        return sum;
    }

    public int calculateQuantityEmploeeINCompany() {
        int quantityEmploeeINCompany = 0;
        for (int i = 0; i < departmentsMap.size(); i++) {
            quantityEmploeeINCompany += departments[i].getEmploeesSizeInDepartment();
        }
        return quantityEmploeeINCompany;
    }

    public double calculateAverageSalaryInCompany() {
        return calculateSumSalariesPerMonthInCompany() / calculateQuantityEmploeeINCompany();
    }


    public double findMinSalaryInCompany() {
        double tempSalary;
        double minSalaryInCompany = departments[0].findEmploeeWithMinSalaryInDepartment().getSalary();
        for (int i = 0; i < departmentSize(); i++) {
            tempSalary = departments[i].findEmploeeWithMinSalaryInDepartment().getSalary();
            if (minSalaryInCompany > tempSalary) {
                minSalaryInCompany = tempSalary;
            }
        }
        return minSalaryInCompany;
    }

    public double findMaxSalaryInCompany() {
        double tempSalary;
        double maxSalaryInCompany = departments[0].findEmploeeWithMaxSalaryInDepartment().getSalary();
        for (int i = 0; i < departmentSize(); i++) {
            tempSalary = departments[i].findEmploeeWithMaxSalaryInDepartment().getSalary();
            if (maxSalaryInCompany < tempSalary) {
                maxSalaryInCompany = tempSalary;
            }
        }
        return maxSalaryInCompany;
    }

    public int countMinSalaryInCompany() {
        int count = 0;
        for (int i = 0; i < departmentSize(); i++) {
            if (departments[i].findEmploeeWithMinSalaryInDepartment().getSalary() == findMinSalaryInCompany()) {
                count++;
            }
        }
        return count;
    }

    public int countMaxSalaryInCompany() {
        int count = 0;
        for (int i = 0; i < departmentSize(); i++) {
            if (departments[i].findEmploeeWithMaxSalaryInDepartment().getSalary() == findMaxSalaryInCompany()) {
                count++;
            }
        }
        return count;
    }

    public Emploee[] findAllEmploeeWithMinSalaryInCompany() {
        Emploee[] minSalaryEmploeesInCompany = new Emploee[countMinSalaryInCompany()];
        int j = 0;
        for (int i = 0; i < departmentSize(); i++) {
            if (departments[i].findEmploeeWithMinSalaryInDepartment().getSalary() == findMinSalaryInCompany()) {
                minSalaryEmploeesInCompany[j] = departments[i].findEmploeeWithMinSalaryInDepartment();
                j++;
            }
        }
        return minSalaryEmploeesInCompany;
    }

    public Emploee[] findAllEmploeeWithMaxSalaryInCompany() {
        Emploee[] maxSalaryEmploeesInCompany = new Emploee[countMaxSalaryInCompany()];
        int j = 0;
        for (int i = 0; i < departmentSize(); i++) {
            if (departments[i].findEmploeeWithMaxSalaryInDepartment().getSalary() == findMaxSalaryInCompany()) {
                maxSalaryEmploeesInCompany[j] = departments[i].findEmploeeWithMaxSalaryInDepartment();
                j++;
            }
        }
        return maxSalaryEmploeesInCompany;
    }

    public void indexSalaryAllEmploees(final double percent) {
        for (int i = 0; i < departmentSize(); i++) {
            departments[i].indexSalaryEmploeeOfDepartment(percent);
        }
    }

    public Emploee findEmploeeInCompanyById(final int idEmploee) {
        Emploee emploeebyId = departments[0].findEmploeeInDepartmentByID(idEmploee);
        for (int i = 0; i < departmentSize(); i++) {
            if (idEmploee == departments[i].findEmploeeInDepartmentByID(idEmploee).getId()) {
                emploeebyId = departments[i].findEmploeeInDepartmentByID(idEmploee);
            }

        }
        return emploeebyId;
    }

    public void findAndPrintEmploeesWithSalaryLessThanInCompany(double baseSalary) {
        for (int i = 0; i < departmentSize(); i++) {
            departments[i].findAndPrintEmploeesWithSalaryLessThanInDepartment(baseSalary);
        }
    }
}