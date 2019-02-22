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

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author cecil
 */
public class DBConnection {

    public static Connection getConnectionToDatabase() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver registered");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3360/hplus", "root", "");
            
        } catch (ClassNotFoundException exc) {
            System.out.println("Deu ruim. Cara cadê meu driver?");
            exc.printStackTrace();

        } catch (SQLException exc) {
            System.out.println("Deu ruim. SQL ferrado");
            exc.printStackTrace();

        }
        
        if(connection != null) {
            System.out.println("Só alegria, rolou uma conexão!");
        }
        return connection;
    }
}
