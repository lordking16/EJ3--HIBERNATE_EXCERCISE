package mx.com.proyecti;

import java.util.Date;

class EmployeeManagerImplementation {
    public static void main(String[] args) {
        EmployeeManager ME = new EmployeeManager();
        /* Add few employee records in database */
        double empID1 = ME.addEmployee("Zara", "Ali", new Date(), 1000);
        double empID2 = ME.addEmployee("Daisy", "Das", new Date(),5000);
        double empID3 = ME.addEmployee("John", "Paul", new Date(),10000);


        /* List down all the employees */
        for(Employee emp: ME.listEmployees()) {
            System.out.println("Employee id " + emp.getId() + ", fist name "
                    + emp.getFirstName() + ", last name " + emp.getLastName());
        }
        /* Update employee's records */
        //ME.updateEmployee(empID1, 5000);
        /* Delete an employee from the database */
        //ME.deleteEmployee(empID2);
        /* List down new list of the employees */
        //ME.listEmployees();
        ME.listEmployees().stream().forEach(employee -> {
            System.out.println(employee.getFirstName());
        });
    }
}