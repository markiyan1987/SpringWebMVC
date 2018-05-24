/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import java.util.List;
import javax.sql.DataSource;

/**
 *
 * @author markiyan
 */
public interface StoreDAO {
    public void setDataSource(DataSource dataSource);

    public void createStore(String name, String type);

    public Store getStoreById(int id);

    public List listStore();

    public void removeStore(int id);

    public void updateStore(int id, String name, String type);
}
