package mx.com.proyecti;

import java.util.Date;

import jakarta.persistence.*;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_generator")
    @SequenceGenerator(name = "employee_generator", sequenceName = "EMPLOYEE_SEQUENCE", allocationSize = 1)
    private long id;
    private String firstName;
    private String lastName;
    private Date birthdate;
    private double salary;
    public Employee() {
    }
    public Employee(String firstName, String lastName, Date birthdate, double
            salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdate = birthdate;
        this.salary = salary;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}