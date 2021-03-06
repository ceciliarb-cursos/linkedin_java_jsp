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
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author cecil
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setStatus(404);
        req.getRequestDispatcher("login.jsp").forward(req, resp);
//        req.getRequestDispatcher("login.jsp").include(req, resp); //concatena com o que ja printei
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDAO usrDAO = new UserDAO();
        if(usrDAO.validateUser(req.getParameter("username"), req.getParameter("password"))) {
            req.getSession().setAttribute("username", req.getParameter("username"));
            req.getRequestDispatcher("home.jsp").forward(req, resp);
        } else {
            req.setAttribute("error", "Login failed!");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
    }
    
}
