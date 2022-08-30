package ru.maltsevkonstantin.myasoyarapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.maltsevkonstantin.myasoyarapi.models.libraries.Product;
import ru.maltsevkonstantin.myasoyarapi.repos.ProductRepo;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class ProductService {

    private final ProductRepo productRepo;

    @Autowired
    public ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    public List<Product> findAll() {
        return productRepo.findAllByOrderByName();
    }

    @Transactional
    public void save(Product product) {
        productRepo.save(product);
    }
}
