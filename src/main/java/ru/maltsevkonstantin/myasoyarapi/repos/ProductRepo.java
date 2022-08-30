package ru.maltsevkonstantin.myasoyarapi.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.maltsevkonstantin.myasoyarapi.models.libraries.Product;

import java.util.List;

public interface ProductRepo extends JpaRepository<Product, Integer> {
    public List<Product> findAllByOrderByName();
}
