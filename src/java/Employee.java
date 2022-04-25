/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="employee")
@SessionScoped
public class Employee implements Serializable {
    
    private int id;
    private String name;
    private String department;
    private int salary;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
    
    public String Register() throws Exception{
        try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost/employee", "root", "");
                Statement stmt = con.createStatement();
                String query = "insert into employee values(" + this.id + ", '" +
                this.name + "', '" + this.department + "', " + this.salary + ")";
                stmt.executeUpdate(query);
                return "success";
            }

        catch (Exception e) {
            e.printStackTrace();
            return "failure";
        
        }
    }
    
}
