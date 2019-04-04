package com.cskaoyan.erp.dao;


import com.cskaoyan.erp.model.Product;

import java.util.List;

public interface ProductDao {


    List<Product> selectAllProduct();

    Product selectProductById(String id);

    int insertProduct(Product product);

    int updateProduct(Product product);

    int deleteProductById(String[] ids);
}