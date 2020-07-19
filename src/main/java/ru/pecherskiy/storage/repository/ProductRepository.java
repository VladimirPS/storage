package ru.pecherskiy.storage.repository;

import org.springframework.data.repository.CrudRepository;
import ru.pecherskiy.storage.model.Product;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {
    List<Product> findAll();
}
