package examen.utils;

import EXAMEN.model.*;
import com.mysql.cj.x.protobuf.MysqlxDatatypes.Scalar.String;
import com.mysql.cj.xdevapi.Statement;
import java.io.BufferedWriter;
import java.util.Map;
import java.util.Set;
import java.util.List;
import java.util.HashMap;
import java.util.HashSet;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;


public class GestorExamen {
    private Set<Department> departments = new HashSet<>();
    private Map<String, Employee> employees = new HashMap<>();
    private Map<Department, List<Employee>> departmentsXemployees = new HashMap<>();
    
    final java.lang.String MYSQL_CON = "c:\\temp\\mysql.con";
    GestorBBDD gestorBBDD = new GestorBBDD(MYSQL_CON);
    
    
    
        
        
    public void carregaDades()  throws SQLException, IOException {
        /* 1. Carregar les estructures:
            'departments'
            'empleats'
            (1,50 punts) Map<Department, List<Employee>> departmentsXempleats;
         */
        try (Connection conn = gestorBBDD.getConnectionFromFile();
            java.sql.Statement stmt = conn.createStatement()){
            java.lang.String sql = "SELECT email, first_name, last_name, e.department_id, department_name" +
                     "FROM departments d, employees e WHERE d.department_id = e.department_id";
            ResultSet rs = stmt.executeQuery(sql);
            
            while(rs.next()){
                int depId = rs.getInt("department_id");
                java.lang.String depName = rs.getString("department_name");
                java.lang.String firstName = rs.getString("first_name");
                java.lang.String lastName = rs.getString("last_name");
                java.lang.String email = rs.getString("email");
           }
        }
    }


    public void mostraDepartments() {
        /*
           2. Mostra 'departments'
        */
        
        System.out.println("DEPARTMENTS");
        for (Department d : departments) {
        System.out.println(d);
        }

    }   

    public void mostraEmployees() {
        /*
           2. Mostra 'employees'
        */
        System.out.println("EMPLOYEES");
        for(Employee e : employees.values()){
            System.out.println(e);
        } 
    }
    
    public void mostraDepartmentsXEmployees() {
        /*
           2. Mostra 'departmentsXemployees'
        */
        for(Map<Department, List<Employee>> : departmentsXemployees.keySet()){
            System.out.println("Department: " + departments.getKey());
            for (Employee e : employees.getValue()) {
                System.out.println(" - " + e);
            }
        System.out.println("DEPARTMENTS X EMPLOYEES");

    } 
    
    public void desaDepartmentsXEmpleatsCSV(String path) {
        /*
           3. Emmagatzema 'departmentsXemployees' en un arxiu .csv amb el següent format:
              #departmentId, name, email1;email2;email3;...;
        */
        
    }
    
}

