package fr.einfolearning.employee_crud.resources;

import fr.einfolearning.employee_crud.beans.Employee;
import fr.einfolearning.employee_crud.db.dao.EmployeeDAOImpl;
import fr.einfolearning.employee_crud.db.dao.IEmployeeDAO;
import java.sql.SQLException;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/employees")
public class EmployeeRessource {

    private IEmployeeDAO employeeDAO;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/")
    public List<Employee> listAllEmployee() throws WebApplicationException  {

        System.out.println("Entering listAllEmployees");

        List<Employee> employees = null;

        try {
            this.employeeDAO = new EmployeeDAOImpl();

            employees = employeeDAO.getAllEmployees();
            System.out.println("Getting listAllEmployees");
            System.out.println("listAllEmployees employees size ==>" + employees);

        } catch (SQLException e) {
            e.printStackTrace();
             throw new WebApplicationException(
                      "Problème recupération liste employees", 
                      Response.Status.BAD_REQUEST);
        }
        finally {
            return employees;
        }

    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Employee getEmployee(@PathParam("id") int id) throws WebApplicationException {
        System.out.println("Entering getEmployee");

        System.out.println("getEmployee, employeeId==>" + id);

        System.out.println("Entering getEmployee");

        Employee employee = null;

        try {
            this.employeeDAO = new EmployeeDAOImpl();

            employee = employeeDAO.getEmployee(id);
            System.out.println("getEmployee, employee details==>" + employee);

        } catch (SQLException e) {
            e.printStackTrace();
              throw new WebApplicationException(
                      "Problème recupération employee (id)", 
                      Response.Status.BAD_REQUEST);
        } finally {
            return employee;
        }

    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/")
    public Employee insertEmployee(Employee employee) throws WebApplicationException {
        System.out.println("Entering insertEmployee");

        try {
            this.employeeDAO = new EmployeeDAOImpl();

            //Employee employee = new Employee(name, address, email, phone);
            System.out.println(employee);
            Employee employeeRes = employeeDAO.addEmployee(employee);
            System.out.println("insertResult result ==>" + employeeRes==null);
            return employeeRes;
        } catch (SQLException e) {
            throw new WebApplicationException("L'insertion de l'employe n'a pu avoir lieu", Response.Status.BAD_REQUEST);
        }
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/")
    public Employee updateEmployee(Employee employee) throws WebApplicationException {
        System.out.println("Entering updateEmployee");

        try {
            this.employeeDAO = new EmployeeDAOImpl();

            //Employee employee = new Employee(name, address, email, phone);
            System.out.println(employee);
            Employee employeeRes = employeeDAO.updateEmployee(employee);
            System.out.println("updateResult result ==>" + employeeRes==null);
            return employeeRes;
        } catch (SQLException e) {
            throw new WebApplicationException("La mise à jour de l'employe n'a pu avoir lieu", Response.Status.BAD_REQUEST);
        }
    }

    @DELETE
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/{id}")
    public boolean deleteEmployee(
            @PathParam("id") int id
    ) throws WebApplicationException {
        System.out.println("Entering deleteEmployee");

        try {
            this.employeeDAO = new EmployeeDAOImpl();

            boolean result = employeeDAO.deleteEmployee(id);
            System.out.println("deleteResult result ==>" + result);
            return result;
            
        } catch (SQLException e) {
            throw new WebApplicationException("La suppression de l'employe n'a pu avoir lieu", Response.Status.BAD_REQUEST);
        }

    }

}
