package Department;

public enum DepartmentType {
     ACCOUNT ("Бухгалтерия"),
     SELLERS ("Отдел продаж"),
     CLEANING ("Клининг");

    private final String value;
    private DepartmentType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
