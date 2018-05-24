
package com;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;


public class StoreMapper implements RowMapper<Store> {

    

    @Override
    public Store mapRow(ResultSet rs, int i) throws SQLException {
        Store store = new Store();
        store.setId(rs.getInt("id"));
        store.setName(rs.getString("name"));
        store.setType(rs.getString("type"));        
        return store;
    }
    
}
