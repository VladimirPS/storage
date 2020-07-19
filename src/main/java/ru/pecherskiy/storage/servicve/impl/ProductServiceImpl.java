package ru.pecherskiy.storage.servicve.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.pecherskiy.storage.model.Product;
import ru.pecherskiy.storage.repository.ProductRepository;
import ru.pecherskiy.storage.servicve.ProductService;

import java.util.List;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;


    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product add(Product product) {
        Product savedProduct = this.productRepository.save(product);
        return savedProduct;
    }

    @Override
    public List<Product> getAll() {
        List<Product> result = productRepository.findAll();
        log.info("In getAll - {} products found", result.size());
        return result;
    }

    @Override
    public boolean delete(Long id) {
        if (productRepository.findById(id).isPresent()) {
            productRepository.deleteById(id);
            log.info("In Delete - product with id:{} successfully deleted", id);
            return true;
        }
        return false;
    }

    @Override
    public Product edit(Product product) {
        Product result = productRepository.findById(product.getId()).orElse(null);
        if (result == null) {
            log.warn("In findById - no product find by id:{}", product.getId());
            return null;
        }

        result.setName(product.getName());
        result.setDescription(product.getDescription());
        result.setPlace_storage(product.getPlace_storage());
        result.setReserved(product.getReserved());
        productRepository.save(result);
        log.info("In findById product:{} found by id:{}", result, product.getId());
        return result;
    }


}
