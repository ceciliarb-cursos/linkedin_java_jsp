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

import com.cecihero.onceagain.beans.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cecil
 */
public class UserDAO {

    public int registerUser(User usr) {
        int rowsAffected = 0;
        try {
            Connection conn = DBConnection.getConnectionToDatabase();
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
}
