package Company;

public class CompanyFullException extends RuntimeException {
    public CompanyFullException() {
        super("Нет места для нового департамента!");
    }
}
