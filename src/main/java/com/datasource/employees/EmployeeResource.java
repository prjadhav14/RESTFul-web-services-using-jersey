package com.datasource.employees;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("employees")
public class EmployeeResource {
	EmployeeRepository repo=new EmployeeRepository();
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Employee> getEmployees() {
		//Fethcing data from repository
		List<Employee> employees=repo.getEmployees();
		return employees;
	}
	@Path("{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Employee getEmployees(@PathParam("id") int id) {
		//Fethcing data from repository
		System.out.println("Inside get using id");
		Employee emp=repo.getEmployees(id);
		System.out.println(emp.toString());
		return emp;
	}
	
	@Path("addEmployee")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Employee addEmployee(Employee e) {
		//Adding employee to repository
		System.out.println("Inside get using id");
		repo.createEmployee(e);
		return e;
	}
	
	@Path("updateemp")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateEmployee(Employee e) {
		if(repo.getEmployees(e.getEmp_id()).getEmp_id()!=0) {
			repo.updateEmployee(e);
			return Response.status(200).entity(e).build();
		}
		else {
			return Response.status(201,"Employee does not exist").entity("Employee does not exist").build();
		}
		
	}
	@Path("deleteEmp")
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteEmployee(Employee e) {
		if(repo.getEmployees(e.getEmp_id()).getEmp_id()!=0) {
			repo.deleteEmployee(e);
			return Response.status(200).entity(e).build();
		}
		else {
			return Response.status(201,"Employee does not exist").entity("Employee does not exist").build();
		}
	}
	
}
