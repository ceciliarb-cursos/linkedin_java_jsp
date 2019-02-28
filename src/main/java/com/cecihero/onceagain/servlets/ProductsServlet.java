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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author cecil
 */
@WebServlet(name = "ProductsServlet", urlPatterns = {"/products"})
public class ProductsServlet extends HttpServlet {
    private ArrayList<String> products;

    @Override
    public void init() throws ServletException {
        this.products = new ArrayList<String>();
        super.init(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        this.products.add(request.getParameter("product"));
        HttpSession session = request.getSession();
        session.setAttribute("noofproducts", this.products);
        request.setAttribute("products", new ArrayList());
        try {
            request.getRequestDispatcher("/search.jsp").forward(request, response);
        } catch (IOException ex) {
            Logger.getLogger(ProductsServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
