package mx.com.proyecti;

import java.util.Date;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmployeeManager {
    private SessionFactory factory;
    public EmployeeManager() {
        try {
            factory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." +
                    ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    /* Method to CREATE an employee in the database */
    public Long addEmployee(String fistName, String lastName, Date birthdate,
                            double salary){
        Session session = factory.openSession();
        Transaction tx = null;
        Long employeeID = null;
        try {
            tx = session.beginTransaction();
            Employee employee = new Employee(fistName, lastName, birthdate,
                    salary);
            session.persist(employee);
            session.flush();
            tx.commit();
            employeeID = employee.getId();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return employeeID;
    }
    public Employee getEmployee(long id) {
        Session session = factory.openSession();
        Employee employee = null;
        try {
            employee = session.get(Employee.class, id);
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return employee;
    }
    /* Method to READ all the employees */
    public List<Employee> listEmployees( ){
        Session session = factory.openSession();
        Transaction tx = null;
        List<Employee> employees = null;
        try {
            tx = session.beginTransaction();
            employees = session.createQuery("from Employee",
                    Employee.class).getResultList();
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return employees;
    }
    /* Method to UPDATE salary for an employee */
    public void updateEmployee(long id, double salary ){
        Session session = factory.openSession();

        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Employee employee = (Employee)session.get(Employee.class, id);
            employee.setSalary(salary);
            session.persist(employee);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
    /* Method to DELETE an employee from the records */
    public void deleteEmployee(long id){
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Employee employee = (Employee)session.get(Employee.class, id);
            session.remove(employee);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}