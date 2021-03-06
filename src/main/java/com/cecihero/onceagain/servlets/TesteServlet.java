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

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author cecil
 */
@WebServlet(urlPatterns = "/teste",
            initParams = @WebInitParam(name = "URL", value = "http://google.com"))
public class TesteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletConfig config = getServletConfig();
        resp.getWriter().write(config.getInitParameter("URL")+"<br>");
        ServletContext context = getServletContext();
        resp.getWriter().write(context.getInitParameter("dbURL")+"<br>");

        String name = req.getParameter("name");
        resp.getWriter().write("alou mamae! it's me, "+name);
//        resp.setStatus(404);
    }
    
    
}
