package EXAMEN.model;

import com.mysql.cj.x.protobuf.MysqlxDatatypes;

public class Employee {

    
    private String firstName;
    private String lastName;
    private String email;
    private Department department;

    public Employee(String fisrtName, String lastName, String email, Department department) {
        this.firstName = fisrtName;
        this.lastName = lastName;
        this.email = email;
        this.department = department;
    }

    public String getFirstName(String firstName) {
        return firstName;
    }

    public String getLastName(String lastName) {
        return lastName;
    }

    public String getEmail(String email1) {
        return email;
    }

    public Department getDepartment() {
        return department;
    }

    public String getFullName() {
        return firstName + lastName;
    }
    @Override
    public String toString() {
        return firstName + " " + lastName + " (" + email + ")";
    }

    

    
}
