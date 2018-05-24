package com;

import java.util.Date;
import java.util.List;
import javax.sql.DataSource;


public interface SellerDAO {
     public void setDataSource(DataSource dataSource);

    public void createSeller(String first_name, String last_name, Date date_of_birth, int salary, int department_id);

    public Seller getSellerById(int id);

    public List listSeller();

    public void removeSeller(int id);

    public void updateSeller(int id, String first_name, String last_name, Date date_of_birth, int salary, int department_id);
    
}
