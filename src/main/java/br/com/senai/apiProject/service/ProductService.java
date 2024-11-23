package br.com.senai.apiProject.service;

import br.com.senai.apiProject.entity.Product;
import br.com.senai.apiProject.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> searchProductByName(String productName) {
        List<Product> products = new ArrayList<>();
        try {
            products = productRepository.findByNameContainingIgnoreCase(productName);

            if (!products.isEmpty()) {
                System.out.println("Found Product: " + products.get(0).getName());
            } else {
                System.out.println("No products found with the name: " + productName);
            }

        } catch (Exception exception) {
            System.out.println("Error while searching for products: " + exception.getMessage());
        }

        return products;
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }
}