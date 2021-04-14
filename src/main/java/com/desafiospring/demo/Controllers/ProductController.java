package com.desafiospring.demo.Controllers;

import com.desafiospring.demo.DTO.ProductDTO;
import com.desafiospring.demo.ExceptionsHandler.findCategoryException;
import com.desafiospring.demo.Repositories.ProductRepositoryImpl;
import com.desafiospring.demo.Services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
// Picos <>

@RestController
public class ProductController {

    // Inyección de dependencia de productService
    @Autowired
    ProductRepositoryImpl productsService;

    // Response con articulos
    @GetMapping("/api/v1/articles")
    public List<ProductDTO> getProducts() {
        return productsService.productList();
    }

    // Response con filtro de categoria
    @GetMapping("/api/v1/articles1")
    public List<ProductDTO> getCategory(@RequestParam(required = false) String categoryName) throws findCategoryException {
        return productsService.get;
    }

    //@GetMapping("api/v1/articles?category={categoryName}&freeShipping={true}")
    //public ProductDTO findByCategoryAndFreeshipping (@PathVariable(value = "categoryName") String categoryUrl, @PathVariable(value = "freeShipping") Boolean freeShipping) {
    //    return null;
    //}

}
