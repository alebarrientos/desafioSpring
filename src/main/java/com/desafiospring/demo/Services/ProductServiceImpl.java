package com.desafiospring.demo.Services;

import com.desafiospring.demo.DTO.ProductDTO;
import com.desafiospring.demo.ExceptionsHandler.findCategoryException;
import com.desafiospring.demo.Repositories.IProductRepository;
import com.desafiospring.demo.Repositories.ProductRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {

    // Inyeccion de dependencia de productRepositoryImpl
    @Autowired
    ProductRepositoryImpl productRepositoryImpl;

    // Implementacion del metodo para listar products bajo la firma del IProductService
    @Override
    public List<ProductDTO> productList() {
        return productRepositoryImpl.productList();
    }


    // Implementacion del metodo para buscar producto por Category bajo la firma de IProductService
    @Override
    public List<ProductDTO> getProductsByCategory(String categoryName) throws findCategoryException {
        ProductDTO product = new ProductDTO();
        product.setCategory(categoryName);
        return productRepositoryImpl.filter(product);
    }

}
