/*
 * Copyright 2019 Pivotal Software, Inc..
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.cecihero.onceagain.dao;

import com.cecihero.onceagain.beans.Order;
import com.cecihero.onceagain.beans.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cecil
 */
public class UserDAO {

    public int registerUser(User usr, Connection conn) {
        int rowsAffected = 0;
        try {
            String sql = "INSERT INTO users VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, usr.getUsername());
            stmt.setString(2, usr.getPassword());
            stmt.setString(3, usr.getFname());
            stmt.setString(4, usr.getLname());
            stmt.setInt(5, usr.getAge());
            stmt.setString(6, usr.getActivity());
            rowsAffected = stmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }

        return rowsAffected;
    }

    public boolean validateUser(String username, String password) {
        boolean isValid = false;
        try {
            Connection conn = DBConnection.getConnectionToDatabase();
            String sql = "select * from users where username=? and password=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet result = stmt.executeQuery();
            while (result.next()) {
                isValid = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return isValid;
    }
    
    public User getProfileDetails(String username) {
        User user = null;
        try {
            Connection conn = DBConnection.getConnectionToDatabase();
            String sql = "select * from users where username=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            ResultSet result = stmt.executeQuery();
            while(result.next()) {
                user = new User(result.getString("username"), 
                                result.getString("password"), 
                                result.getString("first_name"), 
                                result.getString("last_name"),
                                result.getInt("age"),
                                result.getString("activity"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }
    
    public List<Order> getOrders(String username) {
        Order order = null;
        List<Order> result = new ArrayList<>();
        try {
            Connection conn = DBConnection.getConnectionToDatabase();
            String sql = "select * from orders where user_name=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            ResultSet res = stmt.executeQuery();
            while(res.next()) {
                order = new Order(res.getInt("order_id"), 
                                  res.getString("product_name"),
                                  res.getString("image_path"),
                                  res.getDate("order_date"),
                                  res.getString("user_name"));
                result.add(order);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
}
