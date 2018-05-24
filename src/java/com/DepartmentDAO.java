package com;


import java.util.List;
import javax.sql.DataSource;


public interface DepartmentDAO {
     public void setDataSource(DataSource dataSource);

    public void createDepartment(String name, String type, int store_id);

    public Department getDepartmentById(int id);

    public List listDepartment();

    public void removeDepartment(int id);

    public void updateDepartment(int id, String name, String type, int store_id);
    
}
