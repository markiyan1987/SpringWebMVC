/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author markiyan
 */
public class DepartmentDAOImpl implements DepartmentDAO{
    
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    @Override
    public void setDataSource(DataSource dataSource) {
       this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate((javax.sql.DataSource) dataSource);
    }

    @Override
    public void createDepartment(String name, String type, int store_id) {
        String SQL = "INSERT INTO department (name, type, store_id) VALUES (?,?,?)";
        jdbcTemplate.update(SQL, name, type, store_id);
    }

   
    @Override
    public Department getDepartmentById(int id) {
       String SQL = "SELECT department.id, department.name, department.type, store.name as s_name FROM department JOIN store ON department.store_id = store.id WHERE department.id = ?";
        Department department = (Department) jdbcTemplate.queryForObject(SQL, new Object[]{id}, new DepartmentMapper());
        return department;
    }

    @Override
    public List listDepartment() {
       String SQL = "SELECT department.id, department.name, department.type, store.name as s_name FROM department JOIN store ON department.store_id = store.id";
        List<Department> departments = jdbcTemplate.query(SQL, new DepartmentMapper());
        return departments;
    }

    @Override
    public void removeDepartment(int id) {
       String SQL = "DELETE FROM department WHERE id = ?";
        jdbcTemplate.update(SQL, id);
    }

    @Override
    public void updateDepartment(int id, String name, String type, int store_id) {
       String SQL = "UPDATE department SET name = ?,type = ?, store_id = ? WHERE id = ?";
        jdbcTemplate.update(SQL, name, type, store_id, id);     
    }
    
}
