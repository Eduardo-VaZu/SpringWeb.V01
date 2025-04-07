package pe.example.springWeb.v01.service;

import pe.example.springWeb.v01.controller.dto.ProductItem;

import java.util.List;

public interface ProductService {
    List<ProductItem> list();
    void create(ProductItem productItem);
    void update(Integer id, ProductItem productItem);
    void delete(Integer id);
}
