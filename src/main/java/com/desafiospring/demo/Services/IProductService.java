package com.desafiospring.demo.Services;

import com.desafiospring.demo.DTO.ProductDTO;
import com.desafiospring.demo.ExceptionsHandler.findCategoryException;

import java.util.List;
import java.util.Map;

public interface IProductService {

    // Firma para listar productos
    public List<ProductDTO> productList();

    // Firma para listar productos por category
    public List<ProductDTO> getProductsByCategory(String categoryName) throws findCategoryException;
}
