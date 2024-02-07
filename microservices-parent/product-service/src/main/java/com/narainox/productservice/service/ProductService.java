package com.narainox.productservice.service;

import com.narainox.productservice.dto.ProductRequest;
import com.narainox.productservice.dto.ProductResponse;
import com.narainox.productservice.model.Product;
import com.narainox.productservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public void createProduct(ProductRequest productRequest) {
        Product product=new Product();
        product.setDescription(productRequest.getDescription());
        product.setName(productRequest.getName());
        product.setPrice(productRequest.getPrice());
        productRepository.save(product);
    }
    public List<ProductResponse> getProductList()
    {
        List<Product> products = productRepository.findAll();
        return products
                .stream()
                .map(this::dtoToProduct)
                .toList();
    }
    public ProductResponse dtoToProduct(Product product)
    {
        ProductResponse productResponse=new ProductResponse();
        productResponse.setName(product.getName());
        productResponse.setDescription(product.getDescription());
        productResponse.setId(product.getId());
        productResponse.setPrice(product.getPrice());
        return productResponse;
    }
}
