package EXAMEN;

import EXAMEN.model.Department;
import EXAMEN.model.Employee;
import examen.utils.GestorExamen;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import static java.util.stream.Collectors.toList;

public class Main {

    private static Object DepartmentsXEmployees;
    public static void main(String[] args) {
        GestorExamen gestor = new GestorExamen();

        try {
            gestor.carregaDades();

            gestor.mostraDepartments();
            gestor.mostraEmployees();
            gestor.mostraDepartmentsXEmployees();
            
            gestor.desaDepartmentsXEmpleatsCSV("c:\\temp\\departmentXEmpleats.cvs");

            
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
        
        
        List<Department> departments = new HashSet<>(); 
        List<Employee> employees = new HashMap<>();     
        Map<Department, List<Employee>> departmentsXemployees = new HashMap<>(); 
        
        //Departments ordenats per ID
        List<Department> departmentsOrdenats = departments.stream()
                .sorted(Comparator.comparingInt(Department::getDepartmentId))
                .toList();

        //Employees ordenats per FirstName + LastName
        List<Employee> empleatOrdenats = employees.stream()
                .sorted(Comparator.comparing(Employee::getFullName))
                .toList();

        //DepartmentsXEmployees ordenats per ID i per FirstName + LastName
        Map<Department, List<Employee>> mapOrdenat = new HashMap<>();
        for (Department d : departmentsOrdenats) {
            List<Employee> empOrdenats = departmentsXemployees.getOrDefault(d, new ArrayList<>())
                    .stream()
                    .sorted(Comparator.comparing(Employee::getFullName))
                    .toList();

            mapOrdenat.put(d, empleatOrdenats);
        }

    }
    
    
       
}


