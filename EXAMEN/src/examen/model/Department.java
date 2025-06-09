package EXAMEN.model;

public class Department {
    private int departmentId;
    private String name;
    
    public Department(int departmentId, String name) {
        this.departmentId = departmentId;
        this.name = name;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public String getName() {
        return name;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(departmentId);
    }

    @Override
    public String toString() {
        return departmentId + " - " + name;
    }
}
