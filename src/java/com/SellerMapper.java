/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author markiyan
 */
public class SellerMapper implements RowMapper<Seller> {

     @Override
    public Seller mapRow(ResultSet rs, int i) throws SQLException {
        Seller seller = new Seller();
        seller.setId(rs.getInt("id"));
        seller.setFirst_name(rs.getString("first_name"));
        seller.setLast_name(rs.getString("last_name"));
        seller.setDate_of_birth(rs.getDate("date_of_birth"));
        seller.setSalary(rs.getInt("salary"));
        seller.setDepartment(rs.getString("name"));
        return seller;
        
    }
    
}
