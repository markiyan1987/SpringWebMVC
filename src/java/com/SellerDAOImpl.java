/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import java.util.Date;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class SellerDAOImpl implements SellerDAO{
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    @Override
    public void setDataSource(DataSource dataSource) {
      this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate((javax.sql.DataSource) dataSource);
    }

    @Override
    public void createSeller(String first_name, String last_name, Date date_of_birth, int salary, int department_id) {
        String SQL = "INSERT INTO seller (first_name,last_name, date_of_birth,salary,department_id) VALUES (?,?,?,?,?)";

        jdbcTemplate.update(SQL, first_name, last_name, date_of_birth, salary, department_id);
    }

    @Override
    public Seller getSellerById(int id) {
        String SQL = "SELECT seller.id, seller.first_name, seller.last_name, seller.date_of_birth, seller.salary, department.name FROM seller JOIN department ON seller.department_id = department.id WHERE seller.id = ?";
        Seller seller = (Seller) jdbcTemplate.queryForObject(SQL, new Object[]{id}, new SellerMapper());
        return seller;
    }

    @Override
    public List listSeller() {
        String SQL = "SELECT seller.id, seller.first_name, seller.last_name, seller.date_of_birth, seller.salary, department.name FROM seller JOIN department ON seller.department_id = department.id ";
        List<Seller> sellers = jdbcTemplate.query(SQL, new SellerMapper());
        return sellers;
    }

    @Override
    public void removeSeller(int id) {
         String SQL = "DELETE FROM seller WHERE id = ?";
        jdbcTemplate.update(SQL, id);
        
    }

    @Override
    public void updateSeller(int id, String first_name, String last_name, Date date_of_birth, int salary,int department_id) {
         String SQL = "UPDATE student SET first_name = ?,last_name = ?, date_of_birth = ?, salary = ?, department_id = ? WHERE id = ?";
        jdbcTemplate.update(SQL, first_name, last_name, date_of_birth, salary, department_id, id);        
    }
    
}
