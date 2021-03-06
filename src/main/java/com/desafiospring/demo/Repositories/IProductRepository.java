package com.desafiospring.demo.Repositories;

import com.desafiospring.demo.DTO.ProductDTO;
import com.desafiospring.demo.ExceptionsHandler.findCategoryException;

import java.util.List;

public interface IProductRepository {

    // Firma para mapear productos
    public List<ProductDTO> productList();

    // Firma para mapear productos por categoria
    public List<ProductDTO> filter(ProductDTO producto) throws findCategoryException;
}
