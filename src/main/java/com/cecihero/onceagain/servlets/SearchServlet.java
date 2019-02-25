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

import com.cecihero.onceagain.dao.ProductDAO;
import com.cecihero.onceagain.beans.Product;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author cecil
 */
@WebServlet("/search")
public class SearchServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String searchStr = req.getParameter("search");
        ProductDAO prodDao = new ProductDAO();
        List<Product> result = prodDao.getByName(searchStr);
        String page = getHTMLString(req.getServletContext().getRealPath("/search.html"), result);
        resp.getWriter().write(page);
    }

    public String getHTMLString(String filePath, List<Product> prods) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        String line = "";
        StringBuffer sb = new StringBuffer();
        while((line = br.readLine()) != null) {
            sb.append(line);
            
        }
        br.close();
        String page = sb.toString();
        return MessageFormat.format(page, prods.get(0).getProductImgPath(),
                                          prods.get(1).getProductImgPath(),
                                          prods.get(2).getProductImgPath(),
                                          prods.get(0).getProductName(),
                                          prods.get(1).getProductName(),
                                          prods.get(2).getProductName(), 0);
    }

}
