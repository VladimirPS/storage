package ru.pecherskiy.storage.servicve;

import ru.pecherskiy.storage.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAll();

    Product add(Product product);

    boolean delete(Long id);

    Product edit(Product product);
}