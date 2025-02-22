package Department;

public class DepartmentISFullException extends RuntimeException {
    public DepartmentISFullException() {
        super("Нет места для нового сотрудника!");
    }
}
