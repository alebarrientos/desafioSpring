package com.desafiospring.demo.Repositories;

import com.desafiospring.demo.DTO.ProductDTO;
import com.desafiospring.demo.ExceptionsHandler.findCategoryException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;
import com.fasterxml.jackson.core.type.*;

import java.io.File;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class ProductRepositoryImpl implements IProductRepository {

    private List<ProductDTO> products;

    // Implementacion del metodo listar productos
    @Override
    public List<ProductDTO> productList() {
        List<ProductDTO> productDTOList = loadData();
        return productDTOList;
    }

    @Override
    public List<ProductDTO> filter(ProductDTO producto)throws findCategoryException {
        List<ProductDTO> productDTOList = loadData();
        if ( producto.getCategory() != null) {
            productDTOList = filterByCategory(productDTOList, producto);
        }
        return productDTOList;
    }

    public List<ProductDTO> filterByCategory(List<ProductDTO> filterCategory, ProductDTO producto) {
        return filterCategory.stream().filter((ProductDTO p) ->
                p.getCategory().toLowerCase().contains(producto.getCategory().toLowerCase())).collect(Collectors.toList());
    }


    // Disposicion de datos por "dbProducts.json"
    private List<ProductDTO> loadData() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:dbProducts.json");

        } catch (Exception e) {
            e.printStackTrace();
        }

        ObjectMapper objectMapper = new ObjectMapper();
        // Tipo de dato que devuelve
        TypeReference<List<ProductDTO>> typeReference = new TypeReference<List<ProductDTO>>() {};
        List<ProductDTO> productDTOList = null;

        try {
            productDTOList = objectMapper.readValue(file, typeReference);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return productDTOList;
    }


}
