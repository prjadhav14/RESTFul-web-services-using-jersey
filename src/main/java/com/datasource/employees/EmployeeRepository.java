package com.datasource.employees;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository {
	Connection con=null;
	public EmployeeRepository() {
		// TODO Auto-generated constructor stub
		String url="jdbc:mysql://localhost:3306/employees";
		String userName="root";
		String password="enterPasswordForRoot";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection(url,userName,password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public List<Employee> getEmployees() {
		// TODO Auto-generated method stub
		List<Employee> employees=new ArrayList<Employee>();
		String sql="Select * from employees";
		try {
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()) {
				Employee e=new Employee();
				e.setBirthDate(rs.getDate("birth_date"));
				e.setEmp_id(rs.getInt("emp_no"));
				e.setFirstName(rs.getString("first_name"));
				e.setHireDate(rs.getDate("hire_date"));
				e.setLastName(rs.getString("last_name"));
				employees.add(e);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return employees;
	}
	public Employee getEmployees(int id) {
		// TODO Auto-generated method stub
		Employee e=new Employee();
		String sql="Select * from employees where emp_no=?";
		try {
			PreparedStatement st=con.prepareStatement(sql);
			st.setInt(1, id);
			ResultSet rs=st.executeQuery();
			while(rs.next()) {
				e.setBirthDate(rs.getDate("birth_date"));
				e.setEmp_id(rs.getInt("emp_no"));
				e.setFirstName(rs.getString("first_name"));
				e.setHireDate(rs.getDate("hire_date"));
				e.setLastName(rs.getString("last_name"));
				e.setGender(rs.getString("gender"));
			}
		} catch (Exception ex) {
			// TODO Auto-generated catch block
			System.out.println(ex);
		}
		return e;
	}
	public void createEmployee(Employee e) {
		// TODO Auto-generated method stub
		String sql="Insert into employees values(?,?,?,?,?,?)";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, e.getEmp_id());
			ps.setDate(2, e.getBirthDate());
			ps.setString(3, e.getFirstName());
			ps.setString(4,e.getLastName());
			ps.setString(5,e.getGender());
			ps.setDate(6,e.getHireDate());
			ps.executeUpdate();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	public void updateEmployee(Employee e) {
		// TODO Auto-generated method stub
		String sql="Update employees set first_name=? where emp_no=?";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, e.getFirstName());
			ps.setInt(2, e.getEmp_id());
			ps.executeUpdate();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	public void deleteEmployee(Employee e) {
		// TODO Auto-generated method stub
		String sql="Delete from employees where emp_no=?";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, e.getEmp_id());
			ps.executeUpdate();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
}
