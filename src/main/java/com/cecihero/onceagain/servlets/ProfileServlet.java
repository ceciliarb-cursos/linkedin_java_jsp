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
package com.cecihero.onceagain.servlets;

import com.cecihero.onceagain.dao.UserDAO;
import com.cecihero.onceagain.beans.User;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author cecil
 */
@WebServlet("/viewProfile")
public class ProfileServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDAO userDAO = new UserDAO();
        User user = userDAO.getProfileDetails((String)req.getSession().getAttribute("username"));
        req.setAttribute("user", user);
        
        Map<String, Double> weightSumary = new HashMap<>();
        weightSumary.put("January", 59.0);
        weightSumary.put("February", 59.4);
        weightSumary.put("March", 58.7);
        weightSumary.put("April", 58.5);
        req.setAttribute("weightSumary", weightSumary);
                
        req.getRequestDispatcher("profile.jsp").forward(req, resp); //concatena com o que ja printei
    }    
}
