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

    // Implementacion del metodo buscar por categoria
    @Override
    public List<ProductDTO> getProductByCategory(String categoryName) throws findCategoryException {

        try {
            List<ProductDTO> productDTOList = null;
            productDTOList = loadData();
            List<ProductDTO> listByCategory = null;
            if (productDTOList != null){
                // manipular flujo de datos de la coleccion
                listByCategory = productDTOList.stream()
                        .filter(ProductDTO -> checkIfEquals(ProductDTO, categoryName))
                        .collect(Collectors.toList());
            }
            return listByCategory;

        } catch (Exception e) {
            throw new findCategoryException(categoryName);
        }

    }

    private boolean checkIfEquals(ProductDTO productDTO, String categoryName) {
        return productDTO.equals(categoryName);
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
