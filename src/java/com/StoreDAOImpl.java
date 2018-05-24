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
public class StoreDAOImpl implements StoreDAO{
     private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    @Override
    public void setDataSource(DataSource dataSource) {
       this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate((javax.sql.DataSource) dataSource);
    }

    @Override
    public void createStore(String name, String type) {
        String SQL = "INSERT INTO store (name, type) VALUES (?,?)";
        jdbcTemplate.update(SQL, name, type);
    }

   
    @Override
    public Store getStoreById(int id) {
       String SQL = "SELECT * FROM store WHERE id = ?";
        Store store = (Store) jdbcTemplate.queryForObject(SQL, new Object[]{id}, new StoreMapper());
        return store;
    }

    @Override
    public List listStore() {
       String SQL = "SELECT * FROM store";
        List<Store> stores = jdbcTemplate.query(SQL, new StoreMapper());
        return stores;
    }

    @Override
    public void removeStore(int id) {
       String SQL = "DELETE FROM store WHERE id = ?";
        jdbcTemplate.update(SQL, id);
    }

    @Override
    public void updateStore(int id, String name, String type) {
       String SQL = "UPDATE store SET name = ?,type = ? WHERE id = ?";
        jdbcTemplate.update(SQL, name, type, id);     
    }    
}
