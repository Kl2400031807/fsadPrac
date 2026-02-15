package com.fsad1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class FSADCreate {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/fsad1";
        String user = "root";
        String password = "Akshaya@31807";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection con = DriverManager.getConnection(url, user, password);
                 Statement st = con.createStatement()) {
                System.out.println("Connected to Database");
                String createDept = "CREATE TABLE IF NOT EXISTS dept1 ("+ "dept_id INT PRIMARY KEY, " + "dept_name VARCHAR(50))";
                st.executeUpdate(createDept);
                System.out.println("Dept table created.");
                String createEmp = "CREATE TABLE IF NOT EXISTS employee1 ("+ "emp_id INT PRIMARY KEY, " + "emp_name VARCHAR(50), " + "salary DOUBLE, " + "dept_id INT, " + "FOREIGN KEY (dept_id) REFERENCES dept1(dept_id))";
                st.executeUpdate(createEmp);
                System.out.println("Employee table created.");
                st.executeUpdate("INSERT IGNORE INTO dept1 (dept_id, dept_name) VALUES (1, 'HR')");
                st.executeUpdate("INSERT IGNORE INTO dept1 (dept_id, dept_name) VALUES (2, 'Sales')");
                st.executeUpdate("INSERT IGNORE INTO dept1 (dept_id, dept_name) VALUES (3, 'IT')");
                System.out.println("Dept values inserted.");
                st.executeUpdate("INSERT IGNORE INTO employee1 (emp_id, emp_name, salary, dept_id) VALUES (102, 'Bob', 60000, 2)");
                st.executeUpdate("INSERT IGNORE INTO employee1 (emp_id, emp_name, salary, dept_id) VALUES (103, 'Charlie', 70000, 3)");
                System.out.println("Employee values inserted.");
                System.out.println("Done and Connection Closed.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
