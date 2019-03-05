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
package com.cecihero.onceagain.beans;

import java.sql.Date;

/**
 *
 * @author cecil
 */
public class Order {
    private int id;
    private String productName;
    private String imgPath;
    private Date orderDate;
    private String username;

    public Order(String productName, String imgPath, Date orderDate, String username) {
        this.productName = productName;
        this.imgPath = imgPath;
        this.orderDate = orderDate;
        this.username = username;
    }

    public Order(int id, String productName, String imgPath, Date orderDate, String username) {
        this.id = id;
        this.productName = productName;
        this.imgPath = imgPath;
        this.orderDate = orderDate;
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    
}
